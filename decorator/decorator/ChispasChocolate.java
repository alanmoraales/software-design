package decorator;

import bebidas.Bebida;

public class ChispasChocolate extends DecoratorBebida {
	public ChispasChocolate(Bebida bebida) {
		super(bebida);
		this.bebida.setPrecio(this.bebida.getPrecio() + 10);
		System.out.println("agregando chispas de chocolate...");
	}
}
