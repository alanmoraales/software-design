package composite;

public class Platillo extends MenuItem {

	private float price;
	
	public Platillo(String name, float price) {
		super(name);
		this.price = price;
	}
	
	@Override
	public String print() {
		return this.getName() + ": $" + this.price;
	}

}
