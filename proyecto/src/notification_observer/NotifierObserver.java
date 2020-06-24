package notification_observer;

import notifications.Notification;

public interface NotifierObserver {
    void onNotification(Notification notification);
}
