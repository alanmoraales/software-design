
package store_factories;

import stores.DiscStore;
import stores.Store;

public class DiscStoreFactory implements StoreFactory {
    @Override
    public Store getInstance() {
        return DiscStore.getInstance();
    }
    
}
