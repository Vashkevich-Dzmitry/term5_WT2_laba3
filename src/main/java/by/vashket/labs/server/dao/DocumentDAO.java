package by.vashket.labs.server.dao;

import by.vashket.labs.server.bean.Document;
import by.vashket.labs.server.dao.exception.DAOException;

import java.util.List;

public interface DocumentDAO {
    void addDocument(Document document) throws DAOException;
    void deleteDocument(long idDocument) throws DAOException;
    void editDocument(long idDocument) throws DAOException;
    List<Document> listDocuments() throws DAOException;
}
