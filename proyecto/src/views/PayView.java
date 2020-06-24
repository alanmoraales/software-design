package views;
import client_service.PayViewController;
import exceptions.InvalidCoupon;
import exceptions.NotAppliableCoupon;
import exceptions.NotEnoughMoneyException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PayView implements Initializable {

    @FXML private Label totalLbl;
    @FXML private Label changeLbl;
    @FXML private TextField payTf;
    @FXML private Button payBtn;
    @FXML private Button backBtn;
    @FXML private TextField couponTf;
    @FXML private Button applyBtn;

    private PayViewController controller;

    public PayView(PayViewController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.totalLbl.setText(String.valueOf(controller.getMontoTotal()));

        this.payBtn.setOnAction((e) -> pay());
        this.backBtn.setOnAction((e) -> back());
        this.applyBtn.setOnAction((e) -> apply());
    }

    @FXML
    public void pay() {
        try {
            float payment = Float.parseFloat(this.payTf.getText());
            float change = controller.pay(payment);
            this.changeLbl.setText(String.valueOf(change));
            thankYou();
        } catch (NotEnoughMoneyException e){
            alert("La cantidad ingresada no cubre el total.");
        } catch (NumberFormatException e) {
            alert("Ingrese valores númericos.");
        }
    }

    private void thankYou() {
        this.totalLbl.setText(String.valueOf(controller.getMontoTotal()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Su compra ha sido realizada.");
        alert.show();

        payBtn.setDisable(true);
        applyBtn.setDisable(true);
        couponTf.setDisable(true);
        payTf.setDisable(true);
    }

    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.show();
    }

    @FXML
    public void back() {
        this.controller.cancelPay();
    }

    @FXML
    public void apply() {
        String coupon = this.couponTf.getText();
        try {
            this.controller.applyCoupon(coupon);
            this.totalLbl.setText(String.valueOf(controller.getMontoTotal()));
            this.applyBtn.setDisable(true);
        } catch (NotAppliableCoupon | InvalidCoupon e) {
            alert(e.getMessage());
        }

    }
}
