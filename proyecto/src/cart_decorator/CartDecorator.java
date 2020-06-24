package cart_decorator;

import cart.Cart;
import exceptions.*;
import models.Item;
import state.CartState;
import structures.MyList;

import java.util.Enumeration;

public abstract class CartDecorator implements Cart {
    protected Cart cart;

    public CartDecorator() {
        this.cart = null;
    }

    public CartDecorator(Cart cart) {
        this.cart = cart;
    }

    public abstract void setCart(Cart cart) throws NotAppliableCoupon;

    @Override
    public Enumeration itemsList() {
        return this.cart.itemsList();
    }

    @Override
    public void add(Item item) throws FullCartException {
        this.cart.add(item);
    }

    @Override
    public void remove(int itemIndex) throws EmptyCartException {
        this.cart.remove(itemIndex);
    }

    @Override
    public void remove(Item item) throws EmptyCartException, ElementNotFound {
        this.cart.remove(item);
    }

    @Override
    public void cancel() {
        this.cart.cancel();
    }

    @Override
    public int getCapability() {
        return this.cart.getCapability();
    }

    @Override
    public void setCurrentState(CartState currentState) {
         this.cart.setCurrentState(currentState);
    }

    @Override
    public MyList<Item> getItems() {
        return this.cart.getItems();
    }

    @Override
    public boolean isFull() {
        return this.cart.isFull();
    }

    @Override
    public boolean isEmpty() {
        return this.cart.isEmpty();
    }

    public Cart getCart() {
        return this.cart;
    }
}
