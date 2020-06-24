package coupon_appplier;

import cart.Cart;
import cart_decorator.CartDecorator;
import cart_decorator_factories.CartDecoratorFactory;
import coupons.Coupons;
import exceptions.InvalidCoupon;
import exceptions.NotAppliableCoupon;
import models.Client;

public class CartCouponApplier implements CouponApplier {

    private Coupons coupons;
    private boolean couponApplied;

    public CartCouponApplier(Coupons coupons) {
        this.coupons = coupons;
        this.couponApplied = false;
    }

    @Override
    public void apply(String coupon, Cart cart, Client client) throws InvalidCoupon, NotAppliableCoupon {
        CartDecoratorFactory factory = this.coupons.getCoupon(coupon);

        if(factory == null) {
            throw new InvalidCoupon("Este cupón no es válido.");
        }

        CartDecorator decorator = factory.getInstance();
        decorator.setCart(cart);

        client.setCart(decorator);
        couponApplied = true;
    }

    @Override
    public Cart unapply(Cart cart) {
        couponApplied = false;
        return ((CartDecorator) cart).getCart();
    }

    @Override
    public boolean couponApplied() {
        return this.couponApplied;
    }

    @Override
    public void setCouponApplied(boolean bol) {
        this.couponApplied = bol;
    }
}
