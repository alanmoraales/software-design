package stores;

import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import marketplace.MarketPlace;
import cart.Cart;
import models.Client;
import models.Item;
import store_observer.ObservableStore;
import structures.MyLinkedList;
import structures.MyList;

import java.util.Enumeration;

public abstract class Store extends ObservableStore implements MarketPlace {
    private String name;
    private long id;
    private MyList<Item> items;
    private MyList<Client> clients;

    public Store(String name, long id) {
        this.name = name;
        this.id = id;

        this.items = new MyLinkedList<>();
        this.clients = new MyLinkedList<>();
    }

    public Enumeration clientsList() {
        return this.clients.iterator();
    }

    public Enumeration itemsList() {
        return this.items.iterator();
    }

    public void addItemToCart(Cart cart, int itemIndex) throws FullCartException {
        cart.add(items.get(itemIndex));
    }

    public void removeItemFromCart(Cart cart, int itemIndex) throws EmptyCartException, ElementNotFound {
        cart.remove(items.get(itemIndex));
    }

    public void addItem(Item item) {
        this.items.add(item);
        notifyObservers("Nuevo", item.toString() + " - " + this.name);
    }

    @Override
    public void getIn(Client client) {
        client.setCurrentStore(this);
    }

    @Override
    public void getOut(Client client) {
        client.setCurrentStore(null);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
