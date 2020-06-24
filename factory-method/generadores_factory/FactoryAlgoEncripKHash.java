package generadores_factory;

import escriptamiento.AlgoEncriptamiento;
import escriptamiento.KHash;

public class FactoryAlgoEncripKHash implements FactoryAlgoEncriptamiento {

	@Override
	public AlgoEncriptamiento createInstante() {
		KHash kHash = new KHash();
		kHash.configurar();
		return kHash;
	}

}
