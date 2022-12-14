package by.vashket.labs.server.service;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.service.exception.ServiceException;

public interface UserService {
    boolean signIn(User user) throws ServiceException;

    void signOut(User user) throws ServiceException;

    void registration(User user) throws ServiceException;
}
