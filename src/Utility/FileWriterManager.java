package Utility;

import Utility.FileReaderManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class FileWriterManager {
    private FileReaderManager fileReaderManager;

    private ConsoleManager consoleManager;

    public FileWriterManager(FileReaderManager fileReaderManager){
        this.fileReaderManager = fileReaderManager;
        consoleManager = new ConsoleManager();
    }

    public void writeCollectionInFile(CollectionManager collectionManager)  {
        try{
            JAXBContext jc = JAXBContext.newInstance(CollectionManager.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            PrintWriter printWriter;
            if (!(Paths.get(fileReaderManager.getFileName()).toFile().exists())){
                consoleManager.println("file not found, suggest to create a new file");
                consoleManager.print("enter a name for the new file (without .xml): ");
                String newFileName = consoleManager.readString().trim()+".xml";
                printWriter = new PrintWriter(newFileName);

            }
            else{
                printWriter = new PrintWriter(fileReaderManager.getFileName());
            }
            marshaller.marshal(collectionManager, printWriter);
            printWriter.close();
        }
        catch (JAXBException e){
            System.out.println("gg");
        }
        catch (FileNotFoundException e) {
            System.out.println("file was not found");
        }
    }
}
