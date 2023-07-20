package Commands;

import MusicBand.MusicBand;
import Utility.CollectionManager;
import Utility.ConsoleManager;

public class UpdateCommand implements Command{

    private CollectionManager collectionManager;

    private ConsoleManager consoleManager;

    public UpdateCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public UpdateCommand(){};

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "updates element by id";
    }

    @Override
    public void execute() {

        //не совсем понято условие
    }
}
