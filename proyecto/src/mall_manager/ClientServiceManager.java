package mall_manager;

import exceptions.NotEnoughMoneyException;
import models.Client;
import stores.Store;

import java.util.Enumeration;

public interface ClientServiceManager {
    Enumeration storesList();
    float pay(Client client, float money) throws NotEnoughMoneyException;
    void getOut(Client client);
    Store getStore(int storeIndex);
}
