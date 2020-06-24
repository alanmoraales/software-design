package cliente;

import factories.FactoryCientifico;
import factories.FactoryDivulgacion;

public class Main {

	public static void main(String[] args) {
		Cliente clienteCientifico = new Cliente("Alan", "Articulo", 
				"Revista", new FactoryCientifico());
		
		Cliente clienteDivulgacion = new Cliente("Alan", "Articulo", 
				"Revista", new FactoryDivulgacion());
		
		
		clienteCientifico.printClasses();
		clienteDivulgacion.printClasses();

	}

}
