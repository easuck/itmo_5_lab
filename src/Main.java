import Utility.CollectionManager;
import Utility.CommandsManager;
import Utility.FileReaderManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        FileReaderManager fileReaderManager = new FileReaderManager("testFile.xml");
        CollectionManager collectionManager = new CollectionManager(fileReaderManager);
        List<String> saveFileNameForExecute = new ArrayList<>();
        CommandsManager commandsManager = new CommandsManager(collectionManager, fileReaderManager, saveFileNameForExecute);
        commandsManager.manageCommands();
    }
}