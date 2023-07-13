package Commands;

import Utility.ConsoleManager;

public class ExitCommand implements Command{

    ConsoleManager consoleManager;

    public ExitCommand(){
        this.consoleManager = new ConsoleManager();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit the application";
    }

    @Override
    public void execute() {
        consoleManager.println("good bye virubai");
        consoleManager.exit();
    }
}
