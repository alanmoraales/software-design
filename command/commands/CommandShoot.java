package commands;

public class CommandShoot implements Command {
    public void disparar() {
        System.out.println("Disparando");
    }

    @Override
    public void execute() {
        disparar();
    }
}
