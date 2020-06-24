package view_factories;

import client_service.ClientService;
import javafx.scene.Scene;

public interface ViewFactory {
    Scene getInstance(ClientService service);
}
