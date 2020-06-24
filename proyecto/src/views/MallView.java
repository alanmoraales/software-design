package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mall_manager.MallViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class MallView implements Initializable {

    @FXML private TextField nameTf;
    @FXML private Button enterBtn;

    private MallViewManager controller;

    public MallView(MallViewManager controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enterBtn.setOnAction((actionEvent) -> this.enter(actionEvent));
    }

    @FXML
    public void enter(ActionEvent event) {
        String name = nameTf.getText();
        System.out.println(name);

        if(name.length() > 0) {
            controller.newClient(name);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Ingrese un nombre.");
            alert.show();
        }
    }
}
