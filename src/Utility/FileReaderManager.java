package Utility;

import MusicBand.MusicBand;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;

public class FileReaderManager {

    private CollectionManager collectionManager;
    private String fileName;

    public FileReaderManager(String fileName){
        collectionManager = new CollectionManager();
        this.fileName = fileName;
    }

    public FileReaderManager(){};

    public String getFileName() {
        return fileName;
    }

    public HashMap<Integer, MusicBand> readCollection(){
        try{
            File file = new File(fileName);
            JAXBContext jc = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            collectionManager = (CollectionManager) unmarshaller.unmarshal(file);
            return collectionManager.getMusicBands();
        }
        catch(JAXBException e){
            //тут нужно какое-то сообщение об ошибке
            //return new HashMap<Integer, MusicBand>();
            System.out.println("ты обосрался мудак");
            return new HashMap<Integer, MusicBand>();
        }
    }

}
