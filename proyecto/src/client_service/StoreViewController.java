package client_service;

import cart_observer.CartObserver;
import exceptions.ElementNotFound;
import exceptions.EmptyCartException;
import exceptions.FullCartException;
import store_observer.StoreObserver;

import java.util.Enumeration;

public interface StoreViewController {
    Enumeration itemsList();
    void addItemToCart(int itemIndex) throws FullCartException;
    void removeItemFromCart(int itemIndex) throws EmptyCartException, ElementNotFound;
    void leftStore();
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    String getStoreName();
    void addStoreObserver(StoreObserver observer);
    void removeStoreObserver(StoreObserver observer);
}
