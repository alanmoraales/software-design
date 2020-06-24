package cart_decorator;


import cart.Cart;
import exceptions.InvalidCoupon;
import exceptions.NotAppliableCoupon;

public class Compra500 extends CartDecorator {

    @Override
    public float total() {
        float total = this.cart.total();
        total = total - 100;

        return total;
    }

    @Override
    public void setCart(Cart cart) throws NotAppliableCoupon {
        if(cart.total() < 500) {
            throw new NotAppliableCoupon("Necesitas una compra minima de $500 para usar este cupón.");
        }
        this.cart = cart;
    }
}
