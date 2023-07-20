package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class ClearCommand implements Command{

    private CollectionManager collectionManager;

    private ConsoleManager consoleManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public ClearCommand(){};

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clears the collection";
    }

    @Override
    public void execute() {
        collectionManager.clearCollection();
        consoleManager.println("collection was successfully cleared");
    }
}
