
package store_factories;

import stores.PaniniStore;
import stores.Store;

public class PaniniStoreFactory implements StoreFactory {

    @Override
    public Store getInstance() {
        return PaniniStore.getInstance();
    }
    
}
