
package store_factories;

import stores.RubikStore;
import stores.Store;

public class RubikStoreFactory implements StoreFactory{

    @Override
    public Store getInstance() {
        return RubikStore.getInstance();
    }
    
}
