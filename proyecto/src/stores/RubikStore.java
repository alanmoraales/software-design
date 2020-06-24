package stores;


public class RubikStore extends Store{

    private static RubikStore rubik;
    
    private RubikStore(String name, long id) {
        super(name, id);
    }

    public synchronized static RubikStore getInstance(){
        if(rubik == null) {
            rubik = new RubikStore("Rubik's", 1170);
        }
        return rubik;
    }

}
