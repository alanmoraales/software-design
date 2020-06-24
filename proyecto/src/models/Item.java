
package models;

public class Item {

    private String name;
    private long id;
    private long storeID;
    private float price;

    public Item(String name, long id, long storeID, float price) {
        this.name = name;
        this.id = id;
        this.storeID = storeID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getStoreID() {
        return storeID;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + " $" + this.price;
    }
}
