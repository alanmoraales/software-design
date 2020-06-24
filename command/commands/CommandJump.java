package commands;

public class CommandJump implements Command {
    public void brincar() {
        System.out.println("Brincando");
    }

    @Override
    public void execute() {
        brincar();
    }
}
