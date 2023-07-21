package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.UserActionsOnElement;

public class ReplaceIfGreater implements Command{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public ReplaceIfGreater(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();

    }

    public ReplaceIfGreater(){}

    @Override
    public String getName() {
        return "removeIfGreater";
    }

    @Override
    public String getDescription() {
        return "replace element by the key from collection if album length value is lower than given one";
    }

    @Override
    public void execute() {
        Integer key;
        Integer length;
        while(true){
            try{
                consoleManager.print("enter key of element you want to replace: ");
                key = consoleManager.readInt();
                if (!(key instanceof Integer)) throw  new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        while(true){
            try{
                consoleManager.print("enter album length: ");
                length = consoleManager.readInt();
                if (!(length instanceof Integer)) throw  new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        collectionManager.replaceIfGreater(key, length);
    }
}
