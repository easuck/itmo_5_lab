import MusicBand.*;
import Utility.CollectionManager;
import Utility.CommandsManager;
import Utility.FileReaderManager;

import java.util.HashMap;

public class Main {
    public static void main(String[] args)  {
        //для парсинга JO в XML
        /*HashMap<Integer, MusicBand> musicBands = new HashMap<>();

        MusicBand band = new MusicBand("Aurora", new Coordinates(1, 0),
                1, 2, MusicGenre.POP,
                new Album("human", 12));
        musicBands.put(0, band);

        Utility.CollectionManager collectionManager = new Utility.CollectionManager();
        collectionManager.setMusicBands(musicBands);
        Utility.FileReaderManager fileReaderManager = new Utility.FileReaderManager("testFile.xml");
        Utility.FileWriterManager fileWriterManager = new Utility.FileWriterManager(fileReaderManager);
        fileWriterManager.writeCollectionInFile(collectionManager);*/



        FileReaderManager fileReaderManager = new FileReaderManager("testFile.xml");
        CollectionManager collectionManager = new CollectionManager(fileReaderManager);
        CommandsManager commandsManager = new CommandsManager(collectionManager, fileReaderManager);
        commandsManager.manageCommands();

    }
}