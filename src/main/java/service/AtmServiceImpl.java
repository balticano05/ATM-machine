package service;

import entity.ATM;
import entity.Card;

public interface AtmServiceImpl {
    public void checkBalance(Card card, ATM atm);
    public void withdrawMoney(Card card, ATM atm);
    public void depositMoney(Card card, ATM atm);
}
