package client_service;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view_factories.PayViewFactory;
import view_factories.StoreViewFactory;
import view_factories.StoresViewFactory;
import view_factories.ViewFactory;

public class SceneManager {
    private Stage stage;

    public SceneManager(ClientService service) {
        this.stage = new Stage();

        stage.setOnCloseRequest((event) -> service.leftMall());

        this.stage.setResizable(false);
    }

    public void run(ClientService service) {
        switchToStoresView(service);
        stage.show();
    }

    public void dispose() {
        stage.close();
    }

    public void switchToStoreView(ClientService service) {
        Scene scene = generateView(new StoreViewFactory(), service);
        switchScene(scene, service.getStoreName());
    }

    public void switchToStoresView(ClientService service) {
        Scene scene = generateView(new StoresViewFactory(), service);
        switchScene(scene, "tiendas");
    }

    public void switchToPayView(ClientService service) {
        Scene scene = generateView(new PayViewFactory(), service);
        switchScene(scene, "pagar");
    }

    private Scene generateView(ViewFactory factory, ClientService service) {
        return factory.getInstance(service);
    }

    private void switchScene(Scene scene, String title) {
        stage.setTitle("covid store - " + title);
        stage.setScene(scene);
    }


}
