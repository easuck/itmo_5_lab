package Utility;

import Commands.Command;
import Commands.ExitCommand;
import Commands.HelpCommand;

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
    }

    public CommandsManager(){
        commandsListForHelpCommand = new ArrayList<>();
        commandsListForHelpCommand.add(new ExitCommand());
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
                consoleManager.println("no such command");
                consoleManager.print("enter command: ");
            }
            else{
                commandsMap.get(command).execute(command);
                consoleManager.print("enter command: ");
            }
        }
    }


}
