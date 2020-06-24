import commands.CommandBend;
import commands.CommandJump;
import commands.CommandRun;
import commands.CommandShoot;

public class Cliente {
    public Cliente() {
        Juego juego = new Juego();

        juego.setBOTON_A(new CommandBend());
        juego.setBOTON_B(new CommandJump());
        juego.setBOTON_X(new CommandRun());
        juego.setBOTON_Y(new CommandShoot());

        juego.ejecutaComando(Boton.BOTON_A);
        juego.ejecutaComando(Boton.BOTON_B);
        juego.ejecutaComando(Boton.BOTON_X);
        juego.ejecutaComando(Boton.BOTON_Y);
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
    }
}
