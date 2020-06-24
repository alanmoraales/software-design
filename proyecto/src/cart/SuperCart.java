package cart;

import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import models.Item;
import state.CartState;
import state.Empty;
import structures.MyLinkedList;
import structures.MyList;

import java.util.Enumeration;

public class SuperCart implements Cart {
    private MyList<Item> items;
    private int capability;
    private CartState currentState;

    public SuperCart(int capability) {
        this.capability = capability;
        this.items = new MyLinkedList<>();

        this.currentState = new Empty();
    }

    public Enumeration itemsList() {
        return items.iterator();
    }

    public void add(Item item) throws FullCartException {
        this.currentState.add(item, this);
    }

    public void remove(int itemIndex) throws EmptyCartException {
        this.currentState.remove(itemIndex, this);
    }

    @Override
    public void remove(Item item) throws EmptyCartException, ElementNotFound {
        this.currentState.remove(item, this);
    }

    public void cancel(){
        this.currentState.cancel(this);
    }

    public int getCapability() {
        return capability;
    }

    public void setCurrentState(CartState currentState) {
        this.currentState = currentState;
    }

    public float total() {
        float total = 0;

        for(int i=0; i<items.size(); i++) {
            total += items.get(i).getPrice();
        }

        return total;
    }

    public MyList<Item> getItems() {
        return items;
    }

    public boolean isFull() {
        if(this.items.size() == this.capability) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(this.items.size() == 0) {
            return true;
        }
        return false;
    }
}
