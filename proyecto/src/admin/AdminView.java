package admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import marketplace.Mall;
import models.Item;
import stores.Store;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class AdminView implements Initializable {

    @FXML private TextField tfName;
    @FXML private TextField tfPrice;
    @FXML private TextField tfID;
    @FXML private ChoiceBox<String> cbStore;
    @FXML private Button btnAdd;

    private Mall mall;

    public AdminView(Mall mall) {
        this.mall = mall;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> data = FXCollections.observableArrayList();

        Enumeration stores = mall.storesList();
        while(stores.hasMoreElements()) {
            data.add((String)stores.nextElement());
        }

        this.cbStore.setItems(data);
        this.cbStore.getSelectionModel().select(0);

        btnAdd.setOnAction((actionEvent) -> this.add(actionEvent));
    }


    @FXML
    public void add(ActionEvent event) {
        try {

            System.out.println(tfName.getText() + " " + tfPrice.getText() + " " + tfID.getText());
            String name = tfName.getText();
            float price = Float.parseFloat(tfPrice.getText());
            long id = Long.parseLong(tfID.getText());

            Store store = mall.getStore(cbStore.getSelectionModel().getSelectedIndex());
            long storeID = store.getId();

            Item item = new Item(name, id, storeID, price);
            store.addItem(item);

        } catch (Exception e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingrese valores válidos");
            alert.show();
        }
    }



}
