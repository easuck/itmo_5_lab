package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;

public class RemoveLowerCommand implements Command{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public RemoveLowerCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public RemoveLowerCommand(){};
    @Override
    public String getName() {
        return "removeLower";
    }

    @Override
    public String getDescription() {
        return "removes all elements from collection where album length filed value less than given one";
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
        collectionManager.removeLower(length);
    }
}
