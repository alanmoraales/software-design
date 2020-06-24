package state;

import exceptions.EmptyCartException;
import cart.Cart;
import models.Item;

public class Canceled implements CartState {
    @Override
    public void add(Item item, Cart cart) {
        cart.getItems().add(item);

        if(!cart.isFull()) {
            cart.setCurrentState(new NotFull());
        } else {
            cart.setCurrentState(new Full());
        }
    }

    @Override
    public void remove(int itemIndex, Cart cart) throws EmptyCartException {
        throw new EmptyCartException("El carrito está vacio");
    }

    @Override
    public void remove(Item item, Cart cart) throws EmptyCartException {
        throw new EmptyCartException("El carrito está vacio");
    }

    @Override
    public void cancel(Cart cart) {
        cart.setCurrentState(new Canceled());
    }
}
