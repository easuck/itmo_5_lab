import Utility.CollectionManager;
import Utility.CommandsManager;
import Utility.FileReaderManager;

public class Main {
    public static void main(String[] args)  {

        FileReaderManager fileReaderManager = new FileReaderManager("testFile.xml");
        CollectionManager collectionManager = new CollectionManager(fileReaderManager);
        CommandsManager commandsManager = new CommandsManager(collectionManager, fileReaderManager);
        commandsManager.manageCommands();

    }
}