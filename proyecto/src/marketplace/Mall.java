package marketplace;

import cart.SuperCart;
import exceptions.NotEnoughMoneyException;
import cart.Cart;
import models.Client;
import stores.Store;
import structures.MyLinkedList;
import structures.MyList;

import java.util.Enumeration;

public abstract class Mall implements MarketPlace, MallInterface {
    protected String name;
    protected MyList<Store> stores;
    protected MyList<Client> clients;

    public Mall(String name) {
        this.name = name;

        this.stores = new MyLinkedList<>();
        this.clients = new MyLinkedList<>();
    }

    public abstract Cart getCart();

    public Enumeration clientsList() {
        return this.clients.iterator();
    }

    public Enumeration storesList() {
        return this.stores.iterator();
    }

    public float pay(Client client, float money) throws NotEnoughMoneyException {
        float change;
        Cart cart = client.getCart();
        float total = cart.total();

        if(money < total) {
            throw new NotEnoughMoneyException("Dinero insuficiente");
        }

        change = money - total;
        client.setCart(getCart());

        return change;
    }

    @Override
    public Store getStore(int storeIndex) {
        return this.stores.get(storeIndex);
    }

}
