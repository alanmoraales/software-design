package adapter;

import model.PayPal;

public class PayPalAdapter implements AdapterMetodoPago {

	private PayPal payPal;
	
	public PayPalAdapter() {
		this.payPal = new PayPal();
	}
	@Override
	public void pagar(double monto) {
		this.payPal.sendPayment(monto);
	}

}
