package cliente;

import escriptamiento.AlgoEncriptamiento;
import generadores_factory.FactoryAlgoEncriptamiento;

public class Cliente {
	public String encriptar(String str, FactoryAlgoEncriptamiento factory) {
		AlgoEncriptamiento algo = factory.createInstante();
		return algo.encriptar(str);
	}
}
