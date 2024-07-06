package security;

import entity.ATM;
import entity.Card;

public interface SmallSession {

    public void handleCardSession(ATM atm);

    public void handlePinCodeSession(Card foundCard, ATM atm);

}
