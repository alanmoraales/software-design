package state;

import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import cart.Cart;
import models.Item;

public class Full implements CartState {
    @Override
    public void add(Item item, Cart cart) throws FullCartException {
        throw new FullCartException("El carrito está lleno");
    }

    @Override
    public void remove(int itemIndex, Cart cart) {
        cart.getItems().remove(itemIndex);

        if(!cart.isEmpty()) {
            cart.setCurrentState(new NotFull());
        } else {
            cart.setCurrentState(new Empty());
        }
    }

    @Override
    public void remove(Item item, Cart cart) throws EmptyCartException, ElementNotFound {
        cart.getItems().remove(item);

        if(!cart.isEmpty()) {
            cart.setCurrentState(new NotFull());
        } else {
            cart.setCurrentState(new Empty());
        }
    }

    @Override
    public void cancel(Cart cart) {
        cart.getItems().clear();
        cart.setCurrentState(new Canceled());
    }
}
