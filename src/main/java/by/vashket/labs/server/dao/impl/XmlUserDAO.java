package by.vashket.labs.server.dao.impl;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.bean.UserList;
import by.vashket.labs.server.dao.UserDAO;
import by.vashket.labs.server.dao.exception.DAOException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlUserDAO implements UserDAO {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final File file = new File("src/main/resources/users.xml");

    public XmlUserDAO() {
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            JAXBContext unContext = JAXBContext.newInstance(UserList.class);

            marshaller = context.createMarshaller();
            unmarshaller = unContext.createUnmarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean signIn(User user) throws DAOException {
        try {
            UserList users = getUserList();
            for (User user1 : users.getUsers()) {
                if (user1.getLogin().equals(user.getLogin()) &&
                        user1.getPassword().equals(user.getPassword()) &&
                        user1.getUserRole().equals(user.getUserRole()))
                    return true;
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
        return false;
    }

    @Override
    public void registration(User user) throws DAOException {
        try {
            UserList users = getUserList();
            if (checkUserExisting(users, user.getLogin())) {
                users.addUser(user);
                marshaller.marshal(users, file);
            } else {
                throw new DAOException("User with such login already exists");
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    private UserList getUserList() throws JAXBException {
        return (UserList) unmarshaller.unmarshal(file);
    }

    private boolean checkUserExisting(UserList users, String login) {
        return users.getUsers()
                .stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }
}
