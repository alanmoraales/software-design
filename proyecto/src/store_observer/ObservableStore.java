package store_observer;

import exceptions.ElementNotFound;
import structures.MyLinkedList;
import structures.MyList;

public abstract class ObservableStore {
    private MyList<StoreObserver> observers;

    public ObservableStore() {
        this.observers = new MyLinkedList<>();
    }

    public void addObserver(StoreObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserserver(StoreObserver observer) {
        try {
            this.observers.remove(observer);
        } catch (ElementNotFound elementNotFound) {
            //
        }
    }

    protected void notifyObservers(String title, String description) {
        for(int i=0; i < observers.size(); i++){
            observers.get(i).onUpdate(title, description);
        }
    }
}
