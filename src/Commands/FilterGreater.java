package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.UserActionsOnElement;

public class FilterGreater implements Command{

    private CollectionManager collectionManager;
    private ConsoleManager consoleManager;

    public FilterGreater(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        consoleManager = new ConsoleManager();
    }

    public FilterGreater(){}

    @Override
    public String getName() {
        return "filterGreater";
    }

    @Override
    public String getDescription() {
        return "filters elements of collection so number of participants exceeds the given one, then displays elements";
    }

    @Override
    public void execute() {
        Integer numberOfParticipants;
        while(true){
            try{
                consoleManager.print("enter album length: ");
                numberOfParticipants = consoleManager.readInt();
                if (!(numberOfParticipants instanceof Integer)) throw  new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        collectionManager.filterGreater(numberOfParticipants);
    }
}
