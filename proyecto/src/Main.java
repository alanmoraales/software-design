import admin.AdminView;
import cart_decorator_factories.Compra1000Factory;
import cart_decorator_factories.Compra500Factory;
import cart_decorator_factories.HolaMundoFactory;
import coupons.Coupons;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mall_manager.MallManager;
import marketplace.CovidStore;
import models.Item;
import notifications.Notifier;
import store_factories.DiscStoreFactory;
import store_factories.PaniniStoreFactory;
import store_factories.RubikStoreFactory;
import stores.Store;
import views.MallView;


public class Main extends Application {

    private Store rubik, disc, panini;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // setting up
        CovidStore covidStore = new CovidStore();

        rubik = new RubikStoreFactory().getInstance();
        disc = new DiscStoreFactory().getInstance();
        panini = new PaniniStoreFactory().getInstance();

        addDiscItems();
        addPaniniItems();
        addRubikItems();

        covidStore.addStore(rubik);
        covidStore.addStore(disc);
        covidStore.addStore(panini);

        rubik.addObserver(Notifier.getInstance());
        disc.addObserver(Notifier.getInstance());
        panini.addObserver(Notifier.getInstance());

        generateCoupons();


        // views
        AdminView adminView = new AdminView(covidStore);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin/AdminView.fxml"));
        loader.setController(adminView);
        Parent adminRoot = loader.load();

        Stage adminStage = new Stage();
        adminStage.setTitle("admin");
        adminStage.setScene(new Scene(adminRoot, 300, 400));
        adminStage.show();


        MallView mallView = new MallView(new MallManager(covidStore));
        FXMLLoader mallLoader = new FXMLLoader(getClass().getResource("views/MallView.fxml"));
        mallLoader.setController(mallView);
        Parent mallRoot = mallLoader.load();

        Stage mallStage = new Stage();
        mallStage.setTitle("covid store - inicio");
        mallStage.setScene(new Scene(mallRoot, 300, 400));
        mallStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void addRubikItems() {
        rubik.addItem(new Item("Dianma 2x2", 1, rubik.getId(), 150));
        rubik.addItem(new Item("Dianma 3x3", 2, rubik.getId(), 200));
        rubik.addItem(new Item("Mirror 2x2 Gold", 3, rubik.getId(), 200));
        rubik.addItem(new Item("Mirror 3x3 Blue", 4, rubik.getId(), 250));
        rubik.addItem(new Item("Gan 356 3x3", 5, rubik.getId(), 599));
        rubik.addItem(new Item("Aosu WR 4x4", 6, rubik.getId(), 799));
        rubik.addItem(new Item("Meilong 3x3", 7, rubik.getId(), 150));
        rubik.addItem(new Item("Cyclone Boys 3x3", 8, rubik.getId(), 250));
        rubik.addItem(new Item("Valk 3x3", 9, rubik.getId(), 550));
        rubik.addItem(new Item("Floppy", 10, rubik.getId(), 100));
    }
    private void addDiscItems() {
        disc.addItem(new Item("Effet Miroir - Zaz", 1, disc.getId(), 200));
        disc.addItem(new Item("Salva - Los Caligaris", 2, disc.getId(), 200));
        disc.addItem(new Item("Trench - Twenty One Pilots", 3, disc.getId(), 200));
        disc.addItem(new Item("Jazz - Queen", 4, disc.getId(), 250));
        disc.addItem(new Item("YHLQMDLG - Bad Bunny", 5, disc.getId(), 200));
        disc.addItem(new Item("Hard Inn - Copal", 6, disc.getId(), 200));
        disc.addItem(new Item("Fauve - Barzoo", 7, disc.getId(), 200));
        disc.addItem(new Item("Simulation Theory - Muse", 8, disc.getId(), 250));
        disc.addItem(new Item("Is This It - The Strokes", 9, disc.getId(), 250));
        disc.addItem(new Item("Cosmovisiones - Comisario Pantera", 10, disc.getId(), 200));
    }

    private void addPaniniItems() {
        panini.addItem(new Item("Estampas Batman", 1, panini.getId(), 25));
        panini.addItem(new Item("Álbum FIFA", 2, panini.getId(), 100));
        panini.addItem(new Item("Starter Pack Dragon Ball", 3, panini.getId(), 400));
        panini.addItem(new Item("Cómic Darth Vader", 4, panini.getId(), 100));
        panini.addItem(new Item("SAO serie completa", 5, panini.getId(), 310));
        panini.addItem(new Item("Berserk #1", 6, panini.getId(), 80));
        panini.addItem(new Item("Naruto #3", 7, panini.getId(), 80));
        panini.addItem(new Item("Lego Star Wars #10", 8, panini.getId(), 90));
    }

    private void generateCoupons() {
        Coupons coupons = Coupons.getInstance();
        coupons.createCoupon("COMPRA500", new Compra500Factory());
        coupons.createCoupon("COMPRA1000", new Compra1000Factory());
        coupons.createCoupon("HOLAMUNDO", new HolaMundoFactory());
    }

}
