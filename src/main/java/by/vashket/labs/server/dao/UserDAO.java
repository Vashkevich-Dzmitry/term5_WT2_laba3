package by.vashket.labs.server.dao;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(User user) throws DAOException;
    void registration(User user) throws DAOException;
}
