package by.vashket.labs.server.controller.command.impl;

import by.vashket.labs.server.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong command sent";
    }
}
