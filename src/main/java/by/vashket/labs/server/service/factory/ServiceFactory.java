package by.vashket.labs.server.service.factory;

import by.vashket.labs.server.service.ArchiveService;
import by.vashket.labs.server.service.UserService;
import by.vashket.labs.server.service.impl.ArchiveServiceImpl;
import by.vashket.labs.server.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final UserService userServiceImpl = new UserServiceImpl();
    private final ArchiveService archiveServiceImpl = new ArchiveServiceImpl();

    private ServiceFactory() {}

    public UserService getUserService() {
        return userServiceImpl;
    }

    public ArchiveService getArchiveService() {
        return archiveServiceImpl;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
