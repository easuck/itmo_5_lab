package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class RemoveCommand implements Command{

    private CollectionManager collectionManager;

    private ConsoleManager consoleManager;

    public RemoveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public RemoveCommand(){};

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "removes element by key";
    }

    @Override
    public void execute() {
        Integer key;
        while (true) {
            try{
                consoleManager.print("enter key to remove element: ");
                key = consoleManager.readInt();
                if (!(key instanceof Integer)) throw new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        collectionManager.removeElementByKey(key);
    }
}
