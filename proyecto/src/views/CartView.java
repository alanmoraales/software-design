package views;

import cart_observer.CartObserver;
import client_service.CartViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import notifications.Notifier;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class CartView extends VBox implements Initializable, CartObserver {
    @FXML
    private ListView<String> itemsList;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnPay;

    private CartViewController controller;
    private ObserverView observerView;

    public CartView(CartViewController controller) {
        this.controller = controller;
        //this.observerView = observerView;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CartView.fxml"));
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
        updateItems();

        this.btnCancel.setOnAction((actionEvent) -> {
            cancel();
        });

        this.btnPay.setOnAction((actionEvent) -> {
            pay();
        });
    }

    private void updateItems() {
        Enumeration items = controller.getCartItems();
        ObservableList<String> data = FXCollections.observableArrayList();

        while(items.hasMoreElements()) {
            data.add((String)items.nextElement());
        }

        this.itemsList.setItems(data);
    }

    public void pay() {
        observerView.removeObservers();
        controller.toPayView();
    }

    private void cancel() {
        controller.cancel();
    }

    @Override
    public void onItemsChange() {
        updateItems();
    }

    public void setObserverView(ObserverView observerView) {
        this.observerView = observerView;
    }
}
