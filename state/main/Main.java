package main;

import estados.EstadoBloqueado;
import model.Dispositivo;
import model.MEF;

public class Main {

	public static void main(String[] args) {
		Dispositivo disp = new Dispositivo();
		MEF mef = new MEF(disp);
		mef.setStatus(new EstadoBloqueado());
		
		
		// EVENTOS
		
		// en estado bloqueado inicial
		mef.moneda();
		mef.pasar();
		
		// en estado desbloqueado
		mef.moneda();
		mef.moneda();
		
		// vuelve al modo bloqueado
		mef.pasar();
		mef.pasar();
		
		// en modo violación
		mef.reset();
		mef.pasar();
		mef.moneda();
		mef.listo();
		
		// en modo bloqueado
		mef.reset();
		
	}

}
