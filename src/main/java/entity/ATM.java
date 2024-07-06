package entity;

import utils.CardStorage;

public class ATM {
    public static CardStorage storageCards = CardStorage.getInstance();

    public static void addMoney(Card card, double sum) {
        card.setBalance(card.getBalance() + sum);
    }

    public static void getMoney(Card card, double sum) {
        card.setBalance(card.getBalance() - sum);
    }

    public static double showMoney(Card card) {
        return card.getBalance();
    }

    public static Double getAllSum(){
        return storageCards.getSumInATM();
    }

    public static void setAllSum(Double sum){
        storageCards.setSumInATM(sum);
    }
}