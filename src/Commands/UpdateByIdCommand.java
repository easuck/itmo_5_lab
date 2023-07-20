package Commands;

import Utility.CollectionManager;
import Utility.ConsoleManager;
import Utility.UserActionsOnElement;

public class UpdateByIdCommand implements Command{

    private CollectionManager collectionManager;
    private UserActionsOnElement userActionsOnElement;
    private ConsoleManager consoleManager;

    public UpdateByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
        userActionsOnElement = new UserActionsOnElement(collectionManager);
        consoleManager = new ConsoleManager();
    }

    public UpdateByIdCommand(){};

    @Override
    public String getName() {
        return "updateById";
    }

    @Override
    public String getDescription() {
        return "updates element by id";
    }

    @Override
    public void execute() {
        Long id;
        while(true){
            try{
                consoleManager.print("enter id of element you want to update: ");
                id = consoleManager.readLong();
                if (!(id instanceof Long)) throw  new Exception();
                break;
            }
            catch(Exception e){
                consoleManager.println("you must enter a number, try again");
            }
        }
        collectionManager.updateById(id, userActionsOnElement);
    }
}
