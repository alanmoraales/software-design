package decorator;

import bebidas.Bebida;

public class CremaBatida extends DecoratorBebida {

	public CremaBatida(Bebida bebida) {
		super(bebida);
		this.bebida.setPrecio(this.bebida.getPrecio() + 5);
		System.out.println("agregando crema batida...");
	}
}
