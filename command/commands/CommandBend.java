package commands;

public class CommandBend implements Command {
    public void inclinarse() {
        System.out.println("inclinándose");
    }

    @Override
    public void execute() {
        inclinarse();
    }
}
