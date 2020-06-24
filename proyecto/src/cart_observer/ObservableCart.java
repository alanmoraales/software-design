package cart_observer;

import exceptions.ElementNotFound;
import structures.MyLinkedList;
import structures.MyList;

import java.util.Enumeration;

public abstract class ObservableCart {
    private MyList<CartObserver> observers;

    public ObservableCart() {
        this.observers = new MyLinkedList<>();
    }

    public void addObserver(CartObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(CartObserver observer) {
        try {
            this.observers.remove(observer);
        } catch (ElementNotFound elementNotFound) {
            //
        }
    }

    public void notifyObservers() {
        for(int i=0; i<observers.size(); i++) {
            observers.get(i).onItemsChange();
        }
    }
}
