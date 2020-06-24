package cart_decorator;

import cart.Cart;
import exceptions.NotAppliableCoupon;

public class HolaMundo extends CartDecorator {
    @Override
    public float total() {
        float total = this.cart.total();
        total = total - 50;

        return total;
    }

    @Override
    public void setCart(Cart cart) throws NotAppliableCoupon {
        if(cart.total() < 100) {
            throw new NotAppliableCoupon("Necesitas una compra minima de $100 para usar este cupón.");
        }
        this.cart = cart;
    }
}
