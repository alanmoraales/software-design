package estados;

import model.MEF;

public class EstadoDesbloqueado implements Estados {

	@Override
	public void moneda(MEF mef) {
		// TODO Auto-generated method stub
		mef.dispositivo.gracias();
	}

	@Override
	public void pasar(MEF mef) {
		// TODO Auto-generated method stub
		mef.dispositivo.bloquear();
		mef.setStatus(new EstadoBloqueado());
	}

	@Override
	public void listo(MEF mef) {
		System.out.println("Acción no disponible en este estado.");
		
	}

	@Override
	public void reset(MEF mef) {
		System.out.println("Acción no disponible en este estado.");
		
	}

}
