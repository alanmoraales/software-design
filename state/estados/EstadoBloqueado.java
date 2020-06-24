package estados;

import model.MEF;

public class EstadoBloqueado implements Estados {

	@Override
	public void moneda(MEF mef) {
		// TODO Auto-generated method stub
		mef.dispositivo.desbloquear();
		mef.setStatus(new EstadoDesbloqueado());
	}

	@Override
	public void pasar(MEF mef) {
		// TODO Auto-generated method stub
		mef.dispositivo.alarma();
		mef.setStatus(new EstadoViolacion());
		
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
