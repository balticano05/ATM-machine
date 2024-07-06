import entity.ATM;
import security.ATMMenu;

public class StarterApp {

    public static void run(){

        ATM atm = new ATM();
        ATMMenu atmMenu = new ATMMenu();

        atmMenu.runSession(atm);
    }

}
