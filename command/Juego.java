import commands.Command;

public class Juego {

	private Command BOTON_X, BOTON_Y, BOTON_A, BOTON_B;
	public void ejecutaComando(Boton btnPresionado) {
		procesaEntrada(btnPresionado);
	}
	
	public void procesaEntrada (Boton botonPresionado){
		if(botonPresionado == Boton.BOTON_A) BOTON_A.execute();
		if(botonPresionado == Boton.BOTON_B) BOTON_B.execute();
		if(botonPresionado == Boton.BOTON_X) BOTON_X.execute();
		if(botonPresionado == Boton.BOTON_Y) BOTON_Y.execute();
	}

	public void setBOTON_X(Command BOTON_X) {
		this.BOTON_X = BOTON_X;
	}

	public void setBOTON_Y(Command BOTON_Y) {
		this.BOTON_Y = BOTON_Y;
	}

	public void setBOTON_A(Command BOTON_A) {
		this.BOTON_A = BOTON_A;
	}

	public void setBOTON_B(Command BOTON_B) {
		this.BOTON_B = BOTON_B;
	}
}
