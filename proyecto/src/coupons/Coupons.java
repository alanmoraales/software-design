package coupons;

import cart_decorator_factories.CartDecoratorFactory;

import java.util.HashMap;
import java.util.Map;

public class Coupons {
    private Map<String, CartDecoratorFactory> coupons;

    private static Coupons instance;

    private Coupons() {
        this.coupons = new HashMap<>();
    }

    public static synchronized Coupons getInstance() {
        if(instance == null) {
            instance = new Coupons();
        }
        return instance;
    }

    public CartDecoratorFactory getCoupon(String coupon) {
        return this.coupons.get(coupon);
    }

    public void createCoupon(String coupon, CartDecoratorFactory factory) {
        this.coupons.put(coupon, factory);
    }
}
