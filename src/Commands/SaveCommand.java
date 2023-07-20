package Commands;

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
    public void execute() {
        fileWriterManager.writeCollectionInFile(collectionManager);
        consoleManager.println("collection was successfully saved");
    }
}
