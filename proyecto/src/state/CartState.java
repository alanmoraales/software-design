package state;

import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import cart.Cart;
import models.Item;

public interface CartState {
    void add(Item item, Cart cart) throws FullCartException;
    void remove(int itemIndex, Cart cart) throws EmptyCartException;
    void remove(Item item, Cart cart) throws EmptyCartException, ElementNotFound;
    void cancel(Cart cart);
}
