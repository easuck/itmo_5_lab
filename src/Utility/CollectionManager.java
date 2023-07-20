package Utility;

import MusicBand.MusicBand;
import Utility.FileReaderManager;

import javax.xml.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@XmlRootElement(name = "musicBands")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager {

    @XmlElement(name = "musicBand")
    private HashMap<Integer, MusicBand> musicBands = new HashMap<>();
    @XmlTransient
    private ConsoleManager consoleManager = new ConsoleManager();
    @XmlTransient
    private FileReaderManager fileReaderManager;

    public CollectionManager(FileReaderManager fileReaderManager) {
        this.fileReaderManager = fileReaderManager;
        musicBands = fileReaderManager.readCollection();
    }

    public CollectionManager(){};

    public HashMap<Integer, MusicBand> getMusicBands() {
        return musicBands;
    }

    public void setMusicBands(HashMap<Integer, MusicBand> musicBands) {
        this.musicBands = musicBands;
    }

    public int getCollectionSize(){
        return musicBands.size();
    }

    public MusicBand getFirstElement(){
        return musicBands.get(0);
    }

    public void showElements(){
        consoleManager.println("Elements of the collection:");
        for (Map.Entry entry : musicBands.entrySet()){
            consoleManager.println(entry);
        }
    }

    public void insertElementByKey(int key, MusicBand musicBand) {
        musicBands.put(key, musicBand);
    }

    public void removeElementByKey(int key){
        musicBands.remove(key);
    }

    public void clearCollection(){
        musicBands.clear();
    }

    public void updateById(Long id, UserActionsOnElement userActionsOnElement) {
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getId() == id){
                userActionsOnElement.setElementOfCollection(entry.getValue());
            }
            else{
                consoleManager.println("no elements with such id in collection");
            }
        }
    }

    public void removeGreater(int length){
        int count = 0;
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getBestAlbum().getLength() > length) {
                musicBands.remove(entry.getKey());
                count++;
            }
        }
        consoleManager.println(count + " element(s) was/were removed from collection");
    }


}
