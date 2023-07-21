package Commands;

import Exceptions.WrongAmountCommandsException;
import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.FileReaderManager;
import Utility.FileWriterManager;

public class SaveCommand implements Command{

    private CollectionManager collectionManager;

    private ConsoleManager consoleManager;

    private FileWriterManager fileWriterManager;

    public SaveCommand(CollectionManager collectionManager, FileReaderManager fileReaderManager){
        this.collectionManager = collectionManager;
        fileWriterManager = new FileWriterManager(fileReaderManager);
        consoleManager = new ConsoleManager();
    }

    public SaveCommand(){};

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "saves collection in file";
    }

    @Override
    public void execute(String argument) {
        try{
            if (!argument.isEmpty() && !argument.equals(getName())) throw new WrongAmountCommandsException();
            fileWriterManager.writeCollectionInFile(collectionManager);
            consoleManager.println("collection was successfully saved");
        }
        catch (WrongAmountCommandsException ex) {
            consoleManager.println("incorrect command usage, usage example: " + getName());
        }
    }
}
