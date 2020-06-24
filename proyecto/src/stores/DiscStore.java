package stores;


public class DiscStore extends Store{
    
    private static DiscStore disc; 

    private DiscStore(String name, long id) {
        super(name, id);
    }
    
    public synchronized static DiscStore getInstance(){
        if(disc == null){
            disc = new DiscStore("Disc",1234);
        }
        return disc;
    }
}
