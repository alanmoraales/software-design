package marketplace;

import cart.Cart;
import cart.SuperCart;
import exceptions.ElementNotFound;
import models.Client;
import stores.Store;


public class CovidStore extends Mall {

    public CovidStore() {
        super("Covid Store");
    }

    @Override
    public Cart getCart() {
        return new SuperCart(25);
    }

    @Override
    public void getIn(Client client) {
        client.setCart(getCart());
        this.clients.add(client);
    }

    @Override
    public void getOut(Client client) {
        try {
            this.clients.remove(client);
        } catch (ElementNotFound elementNotFound) {
            //
        }
        client = null; // may fail
    }

    public void addStore(Store store) {
        stores.add(store);
    }
}
