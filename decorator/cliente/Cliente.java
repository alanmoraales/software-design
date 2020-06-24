package cliente;

import bebidas.Bebida;
import bebidas.Espresso;
import bebidas.Te;

import decorator.*;

public class Cliente {

	public static void main(String[] args) {
		Bebida expresso = new Espresso();
		System.out.println("Expresso: " + expresso.getPrecio());
		
		// agregando crema batida
		DecoratorBebida crema = new CremaBatida(expresso);
		System.out.println("Expresso: " + expresso.getPrecio());
		
		// aagregando chispas
		DecoratorBebida chispas = new ChispasChocolate(expresso);
		System.out.println("Expresso: " + expresso.getPrecio());
		
		Bebida te = new Te();
		System.out.println("Té: " + te.getPrecio());
		
	}

}
