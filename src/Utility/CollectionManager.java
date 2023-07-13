package Utility;

import MusicBand.MusicBand;
import Utility.FileReaderManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.HashMap;

@XmlRootElement(name = "musicBands")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager {

    @XmlElement(name = "musicBand")
    private HashMap<Integer, MusicBand> musicBands = new HashMap<>();
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
}
