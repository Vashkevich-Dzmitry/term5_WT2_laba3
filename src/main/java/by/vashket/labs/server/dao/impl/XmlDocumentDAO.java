package by.vashket.labs.server.dao.impl;

import by.vashket.labs.server.bean.Document;
import by.vashket.labs.server.bean.DocumentList;
import by.vashket.labs.server.dao.DocumentDAO;
import by.vashket.labs.server.dao.exception.DAOException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class XmlDocumentDAO implements DocumentDAO {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final File file = new File("src/main/resources/documents.xml");

    public XmlDocumentDAO() {
        try {
            JAXBContext context = JAXBContext.newInstance(DocumentList.class);
            JAXBContext unContext = JAXBContext.newInstance(DocumentList.class);

            marshaller = context.createMarshaller();
            unmarshaller = unContext.createUnmarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addDocument(Document document) throws DAOException {
        try {
            DocumentList docs = getDocumentList();
            if (!checkDocumentExisting(docs, document.getId())) {
                docs.addUser(document);
                marshaller.marshal(docs, file);
            } else {
                throw new DAOException("Document with such id already exists");
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteDocument(long idDocument) throws DAOException {
        try {
            DocumentList docs = getDocumentList();
            for (int i = 0; i < docs.getDocuments().size(); i++) {
                if (docs.getDocuments().get(i).getId() == idDocument) {
                    docs.getDocuments().remove(i);
                    break;
                }
            }
            marshaller.marshal(docs, file);
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void editDocument(long idDocument) throws DAOException {
    }

    @Override
    public List<Document> listDocuments() throws DAOException {
        try {
            return getDocumentList().getDocuments();
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    private DocumentList getDocumentList() throws JAXBException {
        return (DocumentList) unmarshaller.unmarshal(file);
    }

    private boolean checkDocumentExisting(DocumentList docs, long id) {
        return docs.getDocuments()
                .stream()
                .anyMatch(document -> document.getId() == id);
    }
}
