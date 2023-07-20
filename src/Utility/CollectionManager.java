package Utility;

import MusicBand.MusicBand;
import Utility.FileReaderManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "musicBands")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager {

    @XmlElement(name = "musicBand")
    private HashMap<Integer, MusicBand> musicBands = new HashMap<>();

    private ConsoleManager consoleManager = new ConsoleManager();
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

    public void updateElementById(long id){
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getId() == id){
                //Дописать
            }
        }
    }

    public void removeElementByKey(int key){
        musicBands.remove(key);
    }

    public void clearCollection(){
        musicBands.clear();
    }
}
