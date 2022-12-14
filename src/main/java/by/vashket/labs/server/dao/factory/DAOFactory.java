package by.vashket.labs.server.dao.factory;

import by.vashket.labs.server.dao.DocumentDAO;
import by.vashket.labs.server.dao.UserDAO;
import by.vashket.labs.server.dao.impl.XmlDocumentDAO;
import by.vashket.labs.server.dao.impl.XmlUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAOImpl = new XmlUserDAO();
    private final DocumentDAO documentDAOImpl = new XmlDocumentDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    private DAOFactory() {}

    public UserDAO getUserDAO() {
        return userDAOImpl;
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAOImpl;
    }
}
