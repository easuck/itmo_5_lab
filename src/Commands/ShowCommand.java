package Commands;

public class ShowCommand implements Command{
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "prints to standard output all elements of the collection";
    }

    @Override
    public void execute(String argument) {
        
    }
}
