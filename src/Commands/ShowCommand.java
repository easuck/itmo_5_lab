package Commands;

import Utility.CollectionManager;

public class ShowCommand implements Command{

    public CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public ShowCommand(){};

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "prints to standard output all elements of the collection";
    }

    @Override
    public void execute() {
        collectionManager.showElements();
    }
}
