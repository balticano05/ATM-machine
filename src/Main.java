import entity.atmmachine.ATM;
import entity.MenuATM;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        MenuATM.runSession(atm);
    }
}