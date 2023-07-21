package Utility;

import Commands.*;
import Exceptions.WrongValuesException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandsManager {

    private HashMap<String, Command> commandsMap;
    private String command;
    private List<Command> commandsListForHelpCommand;
    private ConsoleManager consoleManager;

    public CommandsManager(CollectionManager collectionManager, FileReaderManager fileReaderManager,  List<String> saveFileNameForExecute){
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
        commandsMap.put("removeLower", new RemoveLowerCommand(collectionManager));
        commandsMap.put("replaceIfGreater", new ReplaceIfGreater(collectionManager));
        commandsMap.put("removeFirstByGenre", new RemoveFirstByGenreCommand(collectionManager));
        commandsMap.put("filterGreater", new FilterGreater(collectionManager));
        commandsMap.put("printBestAlbum", new PrintBestAlbumCommand(collectionManager));
        commandsMap.put("executeScript", new ExecuteScriptCommand(collectionManager, fileReaderManager, saveFileNameForExecute));
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
        commandsListForHelpCommand.add(new RemoveLowerCommand());
        commandsListForHelpCommand.add(new ReplaceIfGreater());
        commandsListForHelpCommand.add(new RemoveFirstByGenreCommand());
        commandsListForHelpCommand.add(new FilterGreater());
        commandsListForHelpCommand.add(new PrintBestAlbumCommand());
        commandsListForHelpCommand.add(new ExecuteScriptCommand());
    }

    public HashMap<String, Command> getCommandsMap() {
        return commandsMap;
    }

    public List<Command> getCommandsListForHelpCommand() {
        return commandsListForHelpCommand;
    }

    public void manageCommands(){
        consoleManager.print("enter command: ");
        while (consoleManager.ifScannerHasNext()) {
            try {
                String[] s = consoleManager.readString().trim().split(" ");
                List<String> arrayWithoutSpaces = new ArrayList<>(Arrays.asList(s));
                arrayWithoutSpaces.removeIf(element -> element.equals(""));
                s = arrayWithoutSpaces.toArray(new String[0]);
                if(s.length>2) throw new WrongValuesException("Incorrect number of entered elements");
                if(s.length==2 && s[0].equals(s[1])) throw new WrongValuesException("invalid value format entered");
                if (commandsMap.get(s[0]) == null) {
                    consoleManager.println("no such command");
                    consoleManager.print("enter command: ");
                } else {
                    commandsMap.get(s[0]).execute(s[s.length - 1]);
                    consoleManager.print("enter command: ");
                }
            }catch(WrongValuesException ex){
                consoleManager.println(ex.getMessage());
                consoleManager.print("enter command: ");
            }catch (ArrayIndexOutOfBoundsException ex){
                consoleManager.println("no such command");
                consoleManager.print("enter command: ");
            }
        }
    }

    public HashMap<String, Command> getCommandsMap(CollectionManager collectionManager,
                                                   FileReaderManager fileReaderManager,
                                                   List<String> saveFileNameForExecute){
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
        commandsMap.put("removeLower", new RemoveLowerCommand(collectionManager));
        commandsMap.put("replaceIfGreater", new ReplaceIfGreater(collectionManager));
        commandsMap.put("removeFirstByGenre", new RemoveFirstByGenreCommand(collectionManager));
        commandsMap.put("filterGreater", new FilterGreater(collectionManager));
        commandsMap.put("printBestAlbum", new PrintBestAlbumCommand(collectionManager));
        commandsMap.put("executeScript", new ExecuteScriptCommand(collectionManager,
                fileReaderManager, saveFileNameForExecute));
        return commandsMap;
    }


}
