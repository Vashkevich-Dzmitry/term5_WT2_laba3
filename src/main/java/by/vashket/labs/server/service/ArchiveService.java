package by.vashket.labs.server.service;

import by.vashket.labs.server.bean.Document;
import by.vashket.labs.server.service.exception.ServiceException;

import java.util.List;

public interface ArchiveService {
    void addNewDocument(Document document) throws ServiceException;
    void addEditedDocument(Document document) throws ServiceException;
    List<Document> listAllDocuments() throws ServiceException;
    void deleteDocument(long id) throws ServiceException;
}
