package service;

import entity.ATM;
import entity.Card;

public interface ATMService {

    public void checkBalance(Card card);

    public void withdrawMoney(Card card);

    public void depositMoney(Card card);

}
