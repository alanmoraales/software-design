package client_service;

import cart.Cart;
import cart_observer.ObservableCart;
import coupon_appplier.CouponApplier;
import exceptions.*;
import mall_manager.ClientServiceManager;
import models.Client;
import store_observer.StoreObserver;
import stores.Store;

import java.util.Enumeration;

public class ClientService extends ObservableCart implements StoresViewController, StoreViewController, PayViewController, CartViewController {

    private Client client;
    private ClientServiceManager manager;
    private SceneManager sceneManager;
    private CouponApplier couponApplier;

    public ClientService(Client client, ClientServiceManager manager, CouponApplier couponApplier) {
        super();

        this.client = client;
        this.manager = manager;
        this.sceneManager = new SceneManager(this);
        this.couponApplier = couponApplier;

        sceneManager.run(this);
    }


    @Override
    public Enumeration itemsList() {
        return this.client.getCurrentStore().itemsList();
    }

    @Override
    public void addItemToCart(int itemIndex) throws FullCartException {
        Store store = this.client.getCurrentStore();
        store.addItemToCart(this.client.getCart(), itemIndex);
        notifyObservers();
    }

    @Override
    public void removeItemFromCart(int itemIndex) throws EmptyCartException, ElementNotFound {
        Store store = this.client.getCurrentStore();
        store.removeItemFromCart(this.client.getCart(), itemIndex);
        notifyObservers();
    }

    @Override
    public void leftStore() {
        Store store = this.client.getCurrentStore();
        store.getOut(this.client);
        this.client.setCurrentStore(null);

        this.sceneManager.switchToStoresView(this);
    }

    @Override
    public String getStoreName() {
        return this.client.getCurrentStore().getName();
    }

    @Override
    public void addStoreObserver(StoreObserver observer) {
        this.client.getCurrentStore().addObserver(observer);
    }

    @Override
    public void removeStoreObserver(StoreObserver observer) {
        this.client.getCurrentStore().removeObserserver(observer);
    }

    @Override
    public Enumeration storesList() {
        return this.manager.storesList();
    }

    @Override
    public void getInStore(int storeIndex) {
        Store store = this.manager.getStore(storeIndex);
        store.getIn(this.client);

        this.sceneManager.switchToStoreView(this);
    }

    @Override
    public void toPayView() {
        this.sceneManager.switchToPayView(this);
    }

    @Override
    public void cancel() {
        this.client.getCart().cancel();
        notifyObservers();
    }

    @Override
    public Enumeration getCartItems() {
        return this.client.getCart().itemsList();
    }

    @Override
    public void leftMall() {
        if(this.client.getCurrentStore() != null) {
            leftStore();
        }

        this.manager.getOut(client);
        this.sceneManager.dispose();
    }

    @Override
    public String getClientName() {
        return this.client.getName();
    }

    @Override
    public float pay(float money) throws NotEnoughMoneyException {
        float change = this.manager.pay(client, money);
        couponApplier.setCouponApplied(false);
        return change;
    }

    @Override
    public float getMontoTotal() {
        return this.client.getCart().total();
    }

    @Override
    public void applyCoupon(String coupon) throws NotAppliableCoupon, InvalidCoupon {
        this.couponApplier.apply(coupon, this.client.getCart(), client);
    }

    @Override
    public void cancelPay() {

        if(this.couponApplier.couponApplied()) {
            Cart cart = couponApplier.unapply(this.client.getCart());
            this.client.setCart(cart);
        }

        this.sceneManager.switchToStoresView(this);
    }
}
