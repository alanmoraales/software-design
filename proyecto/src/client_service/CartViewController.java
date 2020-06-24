package client_service;

import cart_observer.CartObserver;

import java.util.Enumeration;

public interface CartViewController {
    void toPayView();
    void cancel();
    Enumeration getCartItems();
}
