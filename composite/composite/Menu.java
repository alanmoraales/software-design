package composite;

import java.util.ArrayList;

public class Menu extends MenuItem {
	private ArrayList<MenuItem> items;

	public Menu(String name) {
		super(name);
		this.items = new ArrayList<>();
	}
	
	public void addItem(MenuItem item) {
		this.items.add(item);
	}
	
	@Override
	public String print() {
		String toReturn = this.getName() + "\n";
		
		for(MenuItem item: items) {
			toReturn += item.print() + "\n";
		}
		
		return toReturn;
	}
	
	
}
