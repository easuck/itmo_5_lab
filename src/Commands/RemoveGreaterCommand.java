package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class RemoveGreaterCommand implements Command{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public RemoveGreaterCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public RemoveGreaterCommand(){};
    @Override
    public String getName() {
        return "removeGreater";
    }

    @Override
    public String getDescription() {
        return "removes all elements from collection where album length filed value exceeds the given one";
    }

    @Override
    public void execute() {
        Integer length;
        while(true){
            try{
                consoleManager.print("enter length of album: ");
                length = consoleManager.readInt();
                if (!(length instanceof Integer)) throw new Exception();
                break;
            }
            catch (Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        collectionManager.removeGreater(length);
    }
}
