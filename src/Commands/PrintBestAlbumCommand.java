package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class PrintBestAlbumCommand implements Command{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public PrintBestAlbumCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public PrintBestAlbumCommand(){}

    @Override
    public String getName() {
        return "printBestAlbum";
    }

    @Override
    public String getDescription() {
        return "prints album field of each element sorted by length in ascending order";
    }

    @Override
    public void execute() {
        collectionManager.printBestAlbumAscending();
    }
}
