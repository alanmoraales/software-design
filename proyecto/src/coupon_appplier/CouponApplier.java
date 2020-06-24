package coupon_appplier;

import cart.Cart;
import exceptions.InvalidCoupon;
import exceptions.NotAppliableCoupon;
import models.Client;

public interface CouponApplier {
    void apply(String coupon, Cart cart, Client client) throws InvalidCoupon, NotAppliableCoupon;
    Cart unapply(Cart cart);
    boolean couponApplied();
    void setCouponApplied(boolean bol);
}
