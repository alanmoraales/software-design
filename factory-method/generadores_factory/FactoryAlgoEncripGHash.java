package generadores_factory;

import escriptamiento.AlgoEncriptamiento;
import escriptamiento.GHash;

public class FactoryAlgoEncripGHash implements FactoryAlgoEncriptamiento {

	@Override
	public AlgoEncriptamiento createInstante() {
		GHash gHash = new GHash();
		gHash.configurar();
		return gHash;
	}

}
