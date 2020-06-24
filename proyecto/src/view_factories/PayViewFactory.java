package view_factories;

import client_service.ClientService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import views.PayView;

import java.io.IOException;

public class PayViewFactory implements ViewFactory {
    @Override
    public Scene getInstance(ClientService service) {
        PayView payView = new PayView(service);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/PayView.fxml"));
        loader.setController(payView);

        try {
            Parent root = loader.load();
            Scene storeScene = new Scene(root, 600, 400);

            return storeScene;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
