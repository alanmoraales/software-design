package adapter;

import model.DebitCard;

public class DebitCardAdapter implements AdapterMetodoPago {

	private DebitCard debitCard;
	
	public DebitCardAdapter() {
		this.debitCard = new DebitCard();
	}
	
	@Override
	public void pagar(double monto) {
		this.debitCard.payment(monto);	
	}

}
