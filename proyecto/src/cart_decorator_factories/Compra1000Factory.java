package cart_decorator_factories;

import cart_decorator.CartDecorator;
import cart_decorator.Compra1000;

public class Compra1000Factory implements CartDecoratorFactory {
    @Override
    public CartDecorator getInstance() {
        return new Compra1000();
    }
}
