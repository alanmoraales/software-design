package cliente;

import generadores_factory.FactoryAlgoEncripKHash;


public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		String cadenaEncriptada = cliente.encriptar("Hola", new FactoryAlgoEncripKHash());
		System.out.println(cadenaEncriptada);
	}

}
