package notifications;

public class NotificationBuilder {
    private String title;
    private String description;

    public NotificationBuilder() {
        this.description = "";
    }

    public NotificationBuilder addTitle(String title) {
        this.title = title;
        return this;
    }

    public NotificationBuilder addDescription(String description) {
        this.description += description;
        return this;
    }

    public Notification build() {
        return new Notification(title, description);
    }
}
