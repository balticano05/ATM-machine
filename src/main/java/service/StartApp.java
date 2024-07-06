package service;

import entity.ATM;
import security.ATMMenu;

public class StartApp implements StartAppImpl {

    public StartApp() {
    }

    public void run(){
        ATM atm = new ATM();
        ATMMenu atmMenu = new ATMMenu();
        atmMenu.runSession(atm);
    }

}
