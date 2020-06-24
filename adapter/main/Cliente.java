package main;

import adapter.*;

public class Cliente {
	
	public void realizarPago(AdapterMetodoPago metodoPago, double monto) {
		metodoPago.pagar(monto);
	}
	
	public static void main(String args[]) {
		Cliente cte = new Cliente();
		cte.realizarPago(new PayPalAdapter(), 1500.50);
		cte.realizarPago(new CreditCardAdapter(), 1500.50);
		cte.realizarPago(new DebitCardAdapter(), 1500.50);
	}

}
