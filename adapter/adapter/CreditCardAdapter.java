package adapter;

import model.CreditCard;

public class CreditCardAdapter implements AdapterMetodoPago {
	private CreditCard creditCard;
	
	public CreditCardAdapter() {
		this.creditCard = new CreditCard();
	}

	@Override
	public void pagar(double monto) {
		this.creditCard.executePay(monto);
	}
	
	
}
