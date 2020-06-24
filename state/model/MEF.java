package model;

import estados.Estados;

public class MEF {
	
	public Estados estadoActual;
	public Dispositivo dispositivo;
	
	public MEF(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public void setStatus(Estados estado) {
		this.estadoActual = estado;
	}

	public void moneda() {
		estadoActual.moneda(this);
	}
	
	public void pasar() {
		estadoActual.pasar(this);
	}
	
	
	public void listo() {
		estadoActual.listo(this);
	}
	
	public void reset() {
		estadoActual.reset(this);
	}
}
