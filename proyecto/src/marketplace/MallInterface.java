package marketplace;

import exceptions.NotEnoughMoneyException;
import cart.Cart;
import models.Client;
import stores.Store;

import java.util.Enumeration;

public interface MallInterface {
    Cart getCart();
    Enumeration clientsList();
    Enumeration storesList();
    float pay(Client client, float money) throws NotEnoughMoneyException;
    void getIn(Client client);
    void getOut(Client client);
    Store getStore(int storeIndex);
}
