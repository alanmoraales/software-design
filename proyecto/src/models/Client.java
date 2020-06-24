
package models;

import cart.Cart;
import stores.Store;

public class Client {
    private String name;
    private Cart Cart;
    private Store currentStore;

    public Client(String name) {
        this.name = name;
        this.Cart = null;
        this.currentStore = null;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return Cart;
    }

    public Store getCurrentStore() {
        return currentStore;
    }

    public void setCurrentStore(Store currentStore) {
        this.currentStore = currentStore;
    }

    public void setCart(cart.Cart cart) {
        Cart = cart;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
