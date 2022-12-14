package by.vashket.labs.server.controller;

import by.vashket.labs.server.controller.command.Command;
import by.vashket.labs.server.controller.command.CommandProvider;

public final class Controller {
    private static final Controller instance = new Controller();
    private Controller() {}

    public static Controller getInstance() {
        return instance;
    }

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        char paramDelimiter = ' ';
        if (request.contains(" ")) {
            commandName = request.substring(0, request.indexOf(paramDelimiter));
        } else {
            commandName = request;
        }
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }
}
