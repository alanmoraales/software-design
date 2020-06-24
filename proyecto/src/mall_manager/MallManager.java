package mall_manager;

import client_service.ClientService;
import coupon_appplier.CartCouponApplier;
import coupon_appplier.CouponApplier;
import coupons.Coupons;
import exceptions.NotEnoughMoneyException;
import marketplace.MallInterface;
import models.Client;
import stores.Store;

import java.util.Enumeration;

public class MallManager implements MallViewManager, ClientServiceManager {
    private MallInterface mall;

    public MallManager(MallInterface mall) {
        this.mall = mall;
    }

    @Override
    public Enumeration storesList() {
        return this.mall.storesList();
    }

    @Override
    public float pay(Client client, float money) throws NotEnoughMoneyException {
        return this.mall.pay(client, money);
    }

    @Override
    public void getOut(Client client) {
        this.mall.getOut(client);
    }

    @Override
    public Store getStore(int storeIndex) {
        return this.mall.getStore(storeIndex);
    }

    @Override
    public void newClient(String name) {
        Client client = new Client(name);
        client.setCart(mall.getCart());

        mall.getIn(client);

        generateService(client);
    }

    private void generateService(Client client) {
        CouponApplier couponApplier = new CartCouponApplier(Coupons.getInstance());
        new ClientService(client, this, couponApplier);
    }
}
