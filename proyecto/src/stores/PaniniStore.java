package stores;


public class PaniniStore extends Store{
    
    private static PaniniStore panini;

    private PaniniStore(String name, long id) {
        super(name, id);
    }

    public synchronized static PaniniStore getInstance(){
        if(panini == null){
            panini = new PaniniStore("Panini",3312);
        }
        return panini;
    }
}
