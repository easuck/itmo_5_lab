import MusicBand.MusicBand;

import java.util.HashMap;
import java.util.Map;

public class CollectionManager {

    private HashMap<Integer, MusicBand> musicBands;

    public CollectionManager(HashMap<Integer, MusicBand> musicBands) {
        this.musicBands = musicBands;
    }

    public void showElementsOfCollection(){
        for (Map.Entry entry: musicBands.entrySet()){
            System.out.println(entry);
        }
    }
}
