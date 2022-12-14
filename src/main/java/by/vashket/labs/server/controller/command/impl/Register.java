package by.vashket.labs.server.controller.command.impl;

import by.vashket.labs.server.bean.User;
import by.vashket.labs.server.controller.command.Command;
import by.vashket.labs.server.service.UserService;
import by.vashket.labs.server.service.exception.ServiceException;
import by.vashket.labs.server.service.factory.ServiceFactory;

public class Register implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(" ");
        String login = splitString[1];
        String password = splitString[2];
        String role = splitString[3];
        String response;
        // get parameters from request and initialize the variables login and password
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService clientService = serviceFactory.getUserService();
        try {
            clientService.registration(new User(login, password, role));
            response = "registered user";
        } catch (ServiceException e) {
            // write log
            response = "Error during register procedure";
        }
        return response;
    }
}
