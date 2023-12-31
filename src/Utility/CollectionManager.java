package Utility;

import AdaptersAndComparators.AlbumLengthComparator;
import Exceptions.NoKeyReferenceException;
import MusicBand.MusicBand;
import MusicBand.Album;
import javax.xml.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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

    public void removeElementByKey(int key) throws NoKeyReferenceException {
        if (!musicBands.containsKey(key)) throw new NoKeyReferenceException();
        musicBands.remove(key);
    }

    public void clearCollection(){
        musicBands.clear();
    }

    public void updateById(Long id, UserActionsOnElement userActionsOnElement) {
        boolean flag = false;
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getId() == id){
                userActionsOnElement.setElementOfCollection(entry.getValue());
                flag = true;
            }
        }
        if (flag == false){
            consoleManager.println(("no elements with such id in collection"));
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

    public void removeLower(int length){
        int count = 0;
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getBestAlbum().getLength() < length) {
                musicBands.remove(entry.getKey());
                count++;
            }
        }
        consoleManager.println(count + " element(s) was/were removed from collection");
    }

    public void replaceIfGreater(int length) {
        try{
            if (musicBands.get(0).getBestAlbum().getLength() < length){
                musicBands.get(0).getBestAlbum().setLength(length);
            }
            else{
                consoleManager.println("album length value of the first element if greater than given one");
            }
        }
        catch(Exception e){
            consoleManager.println("something wrong with length idk");
        }

    }

    public void removeFirstByGenre(String genre){
        boolean flag = false;
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            if (entry.getValue().getGenre().getTitle().equals(genre)){
                musicBands.remove(entry.getKey());
                flag = true;
                break;
            }
        }
        if (flag){
            consoleManager.println("element was successfully removed");
        }
        else{
            consoleManager.println("no elements with such genre");
        }
    }

    public void filterGreater(int numberOfParticipants){
        musicBands.entrySet()
                .stream()
                .filter(e -> e.getValue().getNumberOfParticipants() > numberOfParticipants)
                .forEach(System.out::println);
    }

    public void printBestAlbumAscending(){
        List<Album> listOfLength = new ArrayList<>();
        for (Map.Entry<Integer, MusicBand> entry : musicBands.entrySet()){
            listOfLength.add(entry.getValue().getBestAlbum());
        }
        consoleManager.println("album length of each element in ascending order: ");
        listOfLength
                .stream()
                .sorted(Comparator.comparing(Album::getLength))
                .forEach(System.out::println);
    }
}
