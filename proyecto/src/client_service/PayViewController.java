package client_service;

import exceptions.InvalidCoupon;
import exceptions.NotAppliableCoupon;
import exceptions.NotEnoughMoneyException;

public interface PayViewController {
    float pay(float money) throws NotEnoughMoneyException;
    float getMontoTotal();
    void applyCoupon(String coupon) throws NotAppliableCoupon, InvalidCoupon;
    void cancelPay();
}
