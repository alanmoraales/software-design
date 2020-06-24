package notification_observer;

import exceptions.ElementNotFound;
import notifications.Notification;
import structures.MyLinkedList;
import structures.MyList;

public abstract class ObservableNotifier {
    private MyList<NotifierObserver> observers;

    public ObservableNotifier() {
        this.observers = new MyLinkedList<>();
    }

    public void addObserver(NotifierObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserserver(NotifierObserver observer) {
        try {
            this.observers.remove(observer);
        } catch (ElementNotFound elementNotFound) {
            //nothing
        }
    }

    protected void notifyObservers(Notification notification) {
        for(int i=0; i < observers.size(); i++){
            observers.get(i).onNotification(notification);
        }
    }
}
