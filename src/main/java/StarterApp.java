import controller.ATMMenu;
import utils.CardStorage;

public class StarterApp {
    public static CardStorage storageCards = CardStorage.getInstance();

    public static void run(){
        ATMMenu atmMenu = new ATMMenu();
        atmMenu.runSession();
    }

}
