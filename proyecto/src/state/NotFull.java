package state;

import cart.Cart;
import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import models.Item;

public class NotFull implements CartState {
    @Override
    public void add(Item item, Cart cart) {
        cart.getItems().add(item);

        if(cart.isFull()) {
            cart.setCurrentState(new Full());
        }
    }

    @Override
    public void remove(int itemIndex, Cart cart) {
        cart.getItems().remove(itemIndex);

        if(cart.isEmpty()) {
            cart.setCurrentState(new Empty());
        }
    }

    @Override
    public void remove(Item item, Cart cart) throws EmptyCartException, ElementNotFound {
        cart.getItems().remove(item);

        if(cart.isEmpty()) {
            cart.setCurrentState(new Empty());
        }
    }

    @Override
    public void cancel(Cart cart) {
        cart.getItems().clear();
        cart.setCurrentState(new Canceled());
    }
}
