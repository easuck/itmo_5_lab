import MusicBand.MusicBand;
import MusicBand.Coordinates;
import MusicBand.MusicGenre;
import MusicBand.Album;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, MusicBand> musicBands = new HashMap<Integer, MusicBand>();
        musicBands.put(0, new MusicBand("Linkin park", new Coordinates(0, 0), 5, 10, MusicGenre.RAP, new Album("andromeda", 12)));
        musicBands.put(1, new MusicBand("Eminem", new Coordinates(0, 0), 5, 10, MusicGenre.RAP, new Album("slim shady", 12)));

        CollectionManager collectionManager = new CollectionManager(musicBands);
        collectionManager.showElementsOfCollection();
    }
}