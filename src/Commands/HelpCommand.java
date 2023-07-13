package Commands;

import Utility.CommandsManager;
import Utility.ConsoleManager;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command{

    CommandsManager commandsManager = new CommandsManager();
    ConsoleManager consoleManager;

    public HelpCommand(){
        this.consoleManager = new ConsoleManager();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "command gives a summary of all other commands";
    }

    @Override
    public void execute() {
        List<Command> commands = commandsManager.getCommandsListForHelpCommand();
        consoleManager.println(getName() + ": " + getDescription());
        for (Command command : commands){
            consoleManager.println(command.getName() + ": " + command.getDescription());
        }
    }
}
