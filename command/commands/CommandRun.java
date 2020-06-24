package commands;

public class CommandRun implements Command {
    public void correr() {
        System.out.println("Corriendo");
    }

    @Override
    public void execute() {
        correr();
    }
}
