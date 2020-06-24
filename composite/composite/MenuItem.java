package composite;

public abstract class MenuItem {
	private String name;
	
	public MenuItem(String name) {
		this.name = name;
	}
	public abstract String print();
	
	public String getName() {
		return this.name;
	}
}
