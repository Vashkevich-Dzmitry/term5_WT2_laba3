package by.vashket.labs.server.controller.command.impl;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.controller.command.Command;
import by.vashket.labs.server.service.UserService;
import by.vashket.labs.server.service.exception.ServiceException;
import by.vashket.labs.server.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(" ");
        String login = splitString[1];
        String password = splitString[2];
        String role = splitString[3];
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService clientService = serviceFactory.getUserService();
        try {
            if (clientService.signIn(new User(login, password, role))) {
                response = "Welcome";
            } else {
                response = "Not registered";
            }
        } catch (ServiceException e) {
            response = "Error during login procedure";
        }
        return response;
    }
}
