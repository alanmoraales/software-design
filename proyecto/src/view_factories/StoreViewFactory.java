package view_factories;

import client_service.ClientService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import views.CartView;
import views.NotifierView;
import views.StoreView;
import views.StoresView;

import java.io.IOException;

public class StoreViewFactory implements ViewFactory {
    @Override
    public Scene getInstance(ClientService service) {
        Scene storeScene;
        NotifierView notifierView = new NotifierView();

        CartView cartView = new CartView(service);
        StoreView storeView = new StoreView(service, cartView, notifierView);
        cartView.setObserverView(storeView);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/StoreView.fxml"));
        loader.setController(storeView);

        try {
            Parent root = loader.load();
            storeScene = new Scene(root, 600, 400);

            return storeScene;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
