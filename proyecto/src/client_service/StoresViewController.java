package client_service;

import cart_observer.CartObserver;

import java.util.Enumeration;

public interface StoresViewController {
    Enumeration storesList();
    void getInStore(int storeIndex);
    void leftMall();
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    String getClientName();
}
