package cart_decorator_factories;

import cart_decorator.CartDecorator;
import cart_decorator.HolaMundo;

public class HolaMundoFactory implements CartDecoratorFactory {
    @Override
    public CartDecorator getInstance() {
        return new HolaMundo();
    }
}
