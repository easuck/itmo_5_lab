package Commands;

import MusicBand.MusicBand;
import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.UserAddElement;

public class InsertCommand implements Command{

    private ConsoleManager consoleManager;
    private UserAddElement userAddElement;
    private CollectionManager collectionManager;

    public InsertCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
        userAddElement = new UserAddElement(collectionManager);
    }

    public InsertCommand(){};

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "insert element by the specified key";
    }

    @Override
    public void execute() {
        Integer key;
        while (true) {
            try{
                consoleManager.print("enter key to insert element: ");
                key = consoleManager.readInt();
                if (!(key instanceof Integer)) throw new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        MusicBand musicBand = new MusicBand();
        userAddElement.setElementOfCollection(musicBand);
        collectionManager.insertElementByKey(key, musicBand);
    }
}
