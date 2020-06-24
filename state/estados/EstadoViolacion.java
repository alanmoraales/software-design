package estados;

import model.MEF;

public class EstadoViolacion implements Estados {

	@Override
	public void moneda(MEF mef) {
		// se queda en estado violación
	}

	@Override
	public void pasar(MEF mef) {
		// se queda en estado violación
	}

	@Override
	public void listo(MEF mef) {
		mef.dispositivo.resetAlarma();
		mef.setStatus(new EstadoBloqueado());
	}

	@Override
	public void reset(MEF mef) {
		mef.dispositivo.resetAlarma();
	}

}
