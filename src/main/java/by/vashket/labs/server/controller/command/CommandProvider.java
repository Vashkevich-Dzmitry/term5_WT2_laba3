package by.vashket.labs.server.controller.command;

import by.vashket.labs.server.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTER, new Register());
        repository.put(CommandName.ADD_DOCUMENT, new AddDocument());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.LIST_DOCUMENTS, new ListDocuments());
        repository.put(CommandName.EDIT_DOCUMENT, new EditDocument());
        repository.put(CommandName.DELETE_DOCUMENT, new DeleteDocument());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
