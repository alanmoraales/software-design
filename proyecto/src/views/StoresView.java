package views;

import client_service.StoresViewController;
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

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class StoresView implements Initializable, ObserverView {

    @FXML private Label welcomeLbl;
    @FXML private ListView<String> storesList;
    @FXML private Button exitBtn;
    @FXML private Button enterBtn;
    @FXML private VBox container;

    private StoresViewController controller;
    private CartView cartView;
    private NotifierView notifierView;

    public StoresView(StoresViewController controller, CartView cartView, NotifierView notifierView) {
        this.controller = controller;
        this.cartView = cartView;
        this.notifierView = notifierView;

        controller.addObserver(this.cartView);
        Notifier.getInstance().addObserver(this.notifierView);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.container.getChildren().add(cartView);
        this.container.getChildren().add(notifierView);

        this.welcomeLbl.setText("Bienvenido " + controller.getClientName());
        fillList();

        this.exitBtn.setOnAction((actionEvent) -> {
            exit();
        });

        this.enterBtn.setOnAction((actionEvent) -> {
            enter();
        });
    }

    private void exit() {
        controller.leftMall();
    }

    private void enter() {
        int storeIndex = this.storesList.getSelectionModel().getSelectedIndex();

        if(storeIndex != -1) {
            removeObservers();
            controller.getInStore(storeIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Debes seleccionar una tienda");
            alert.show();
        }

    }

    private void fillList() {
        ObservableList<String> data = FXCollections.observableArrayList();
        Enumeration stores = controller.storesList();

        while(stores.hasMoreElements()) {
            data.add((String)stores.nextElement());
        }

        this.storesList.setItems(data);
    }

    @Override
    public void removeObservers() {
        controller.removeObserver(cartView);
        Notifier.getInstance().removeObserserver(notifierView);
    }
}
