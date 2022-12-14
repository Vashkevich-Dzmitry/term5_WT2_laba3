package by.vashket.labs.server.service.impl;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.dao.UserDAO;
import by.vashket.labs.server.dao.exception.DAOException;
import by.vashket.labs.server.dao.factory.DAOFactory;
import by.vashket.labs.server.service.UserService;
import by.vashket.labs.server.service.UserSession;
import by.vashket.labs.server.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private final UserDAO userDAO = daoObjectFactory.getUserDAO();
    private final UserSession userSession = UserSession.getInstance();

    @Override
    public boolean signIn(User user) throws ServiceException {
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        try {
            if (userDAO.signIn(user)) {
                return userSession.addUser(user);
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(User user) throws ServiceException {
        userSession.removeUser(user);
    }

    @Override
    public void registration(User user) throws ServiceException {
        try {
            userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
