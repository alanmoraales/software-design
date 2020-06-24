package views;

import client_service.StoreViewController;
import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import notifications.Notifier;
import store_observer.StoreObserver;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class StoreView implements Initializable, StoreObserver, ObserverView {

    @FXML private Label storeNameLbl;
    @FXML private ListView<String> itemsList;
    @FXML private Button deleteBtn;
    @FXML private Button addBtn;
    @FXML private Button backBtn;
    @FXML private VBox container;

    private StoreViewController controller;
    private CartView cartView;
    private NotifierView notifierView;

    public StoreView(StoreViewController controller, CartView cartView, NotifierView notifierView) {
        this.controller = controller;
        this.cartView = cartView;
        this.notifierView = notifierView;

        controller.addObserver(this.cartView);
        Notifier.getInstance().addObserver(this.notifierView);
        controller.addStoreObserver(this);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.container.getChildren().add(cartView);
        this.container.getChildren().add(notifierView);

        this.storeNameLbl.setText(controller.getStoreName());
        fillList();

        this.backBtn.setOnAction((actionEvent) -> back());
        this.addBtn.setOnAction((actionEvent) -> add());
        this.deleteBtn.setOnAction((actionEvent) -> remove());
    }

    @FXML
    public void add() {
        int selectedItem = itemsList.getSelectionModel().getSelectedIndex();

        if(selectedItem != -1) {
            try {
                controller.addItemToCart(selectedItem);
            } catch (FullCartException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "¡Tu carrito está lleno!");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Debes seleccionar un producto.");
            alert.show();
        }
    }

    @FXML
    public void remove() {
        int selectedItem = itemsList.getSelectionModel().getSelectedIndex();

        if(selectedItem != -1) {
            try {
                controller.removeItemFromCart(selectedItem);
            } catch (EmptyCartException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "¡Tu carrito está vacio!");
                alert.show();
            } catch (ElementNotFound elementNotFound) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Este item no está en tu carrito.");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Debes seleccionar un producto.");
            alert.show();
        }
    }

    @FXML
    public void back() {
        removeObservers();
        controller.leftStore();
    }

    private void fillList() {
        ObservableList<String> data = FXCollections.observableArrayList();
        Enumeration items = controller.itemsList();

        while(items.hasMoreElements()) {
            data.add((String)items.nextElement());
        }

        this.itemsList.setItems(data);
    }

    @Override
    public void onUpdate(String title, String description) {
        fillList();
    }

    @Override
    public void removeObservers() {
        controller.removeObserver(cartView);
        Notifier.getInstance().removeObserserver(notifierView);
        controller.removeStoreObserver(this);
    }
}
