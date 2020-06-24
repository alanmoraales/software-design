package decorator;

import bebidas.Bebida;

public class DecoratorBebida extends Bebida {
	protected Bebida bebida;
	
	public DecoratorBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
}
