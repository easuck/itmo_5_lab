package Utility;

import Commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandsManager {

    private HashMap<String, Command> commandsMap;
    private String command;
    private List<Command> commandsListForHelpCommand;
    private ConsoleManager consoleManager;

    public CommandsManager(CollectionManager collectionManager, FileReaderManager fileReaderManager){
        consoleManager = new ConsoleManager();
        commandsMap = new HashMap<>();
        commandsMap.put("help", new HelpCommand());
        commandsMap.put("exit", new ExitCommand());
        commandsMap.put("info", new InfoCommand(collectionManager));
        commandsMap.put("show", new ShowCommand(collectionManager));
        commandsMap.put("insert", new InsertCommand(collectionManager));
        commandsMap.put("removeByKey", new RemoveByKeyCommand(collectionManager));
        commandsMap.put("clear", new ClearCommand(collectionManager));
        commandsMap.put("save", new SaveCommand(collectionManager, fileReaderManager));
        commandsMap.put("updateById", new UpdateByIdCommand(collectionManager));
        commandsMap.put("removeGreater", new RemoveGreaterCommand(collectionManager));
    }

    public CommandsManager(){
        commandsListForHelpCommand = new ArrayList<>();
        commandsListForHelpCommand.add(new ExitCommand());
        commandsListForHelpCommand.add(new InfoCommand());
        commandsListForHelpCommand.add(new ShowCommand());
        commandsListForHelpCommand.add(new InsertCommand());
        commandsListForHelpCommand.add(new RemoveByKeyCommand());
        commandsListForHelpCommand.add(new ClearCommand());
        commandsListForHelpCommand.add(new SaveCommand());
        commandsListForHelpCommand.add(new UpdateByIdCommand());
        commandsListForHelpCommand.add(new RemoveGreaterCommand());
    }

    public HashMap<String, Command> getCommandsMap() {
        return commandsMap;
    }

    public List<Command> getCommandsListForHelpCommand() {
        return commandsListForHelpCommand;
    }

    public void manageCommands(){
        consoleManager.print("enter command: ");
        while (consoleManager.ifScannerHasNext()){
            command = consoleManager.readString().trim();
            if (!commandsMap.containsKey(command)){
                consoleManager.println("no such command, try write \"help\" for available commands");
                consoleManager.print("enter command: ");
            }
            else{
                commandsMap.get(command).execute();
                consoleManager.print("enter command: ");
            }
        }
    }


}
