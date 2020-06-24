package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import notification_observer.NotifierObserver;
import notifications.Notification;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NotifierView extends VBox implements Initializable, NotifierObserver {

    @FXML
    private ListView<String> notifications;
    private ObservableList<String> data;

    public NotifierView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotifierView.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.data = FXCollections.observableArrayList();
        this.notifications.setItems(data);
    }

    @Override
    public void onNotification(Notification notification) {
        this.data.clear();
        this.data.add(notification.getTitle() + ": " + notification.getDescription());
    }
}
