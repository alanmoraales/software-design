package notifications;

import notification_observer.ObservableNotifier;
import store_observer.StoreObserver;

public class Notifier extends ObservableNotifier implements StoreObserver {

    private static Notifier notifier = null;

    private Notifier() {
        super();
    }

    public synchronized static Notifier getInstance() {
        if(notifier == null) {
            notifier = new Notifier();
        }
        return notifier;
    }

    @Override
    public void onUpdate(String title, String description) {
        NotificationBuilder builder = new NotificationBuilder();
        Notification notification = builder.addTitle(title)
                                        .addDescription(description).build();

        notifyObservers(notification);
    }
}
