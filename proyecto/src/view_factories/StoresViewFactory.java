package view_factories;

import client_service.ClientService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import views.CartView;
import views.NotifierView;
import views.StoresView;

import java.io.IOException;

public class StoresViewFactory implements ViewFactory {
    @Override
    public Scene getInstance(ClientService service) {
        Scene storesScene;
        NotifierView notifierView = new NotifierView();

        CartView cartView = new CartView(service);
        StoresView storesView = new StoresView(service, cartView, notifierView);
        cartView.setObserverView(storesView);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/StoresView.fxml"));
        loader.setController(storesView);

        try {
            Parent root = loader.load();
            storesScene = new Scene(root, 600, 400);

            return storesScene;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
