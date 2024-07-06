package entity;

import utils.CardStorage;

public class ATM {
    public static CardStorage storageCards = CardStorage.getInstance();;

    public void addMoney(Card card, double sum) {
        card.setBalance(card.getBalance() + sum);
    }

    public void getMoney(Card card, double sum) {
        card.setBalance(card.getBalance() - sum);
    }

    public double showMoney(Card card) {
        return card.getBalance();
    }

    public static Card findCard(String cardNum) {
        for (Card card : storageCards.getCards()) {
            if (card.getCardNumber().equals(cardNum)) {
                return card;
            }
        }
        return null;
    }

    public static Double getAllSum(){
        return storageCards.getSumInATM();
    }

    public static void setAllSum(Double sum){
        storageCards.setSumInATM(sum);
    }
}