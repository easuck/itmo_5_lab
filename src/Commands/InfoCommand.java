package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class InfoCommand implements Command{

    public ConsoleManager consoleManager;
    public CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager){
        this.consoleManager = new ConsoleManager();
        this.collectionManager = collectionManager;
    }

    public InfoCommand(){};

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "shows information about collection";
    }

    @Override
    public void execute() {
        consoleManager.println("Type of collection: music bands");
        consoleManager.println("Count elements in collection: " + collectionManager.getCollectionSize());
        if (collectionManager.getCollectionSize() != 0){
            consoleManager.println("Inicialization date: " + collectionManager.getFirstElement().getCreationDate());
        }
    }
}
