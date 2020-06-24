package cart_decorator_factories;

import cart_decorator.CartDecorator;
import cart_decorator.Compra500;

public class Compra500Factory implements CartDecoratorFactory {
    @Override
    public CartDecorator getInstance() {
        return new Compra500();
    }
}
