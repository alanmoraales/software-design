package cart;


import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import models.Item;
import state.CartState;
import structures.MyList;

import java.util.Enumeration;

public interface Cart {

    Enumeration itemsList();
    void add(Item item) throws FullCartException;
    void remove(int itemIndex) throws EmptyCartException;
    void remove(Item item) throws EmptyCartException, ElementNotFound;
    void cancel();
    int getCapability();
    void setCurrentState(CartState currentState);
    float total();
    MyList<Item> getItems();
    boolean isFull();
    boolean isEmpty();
}
