package entity.atmmachine;

import entity.cards.Card;
import entity.cards.StorageCards;

public class ATM {
    static StorageCards storageCards = StorageCards.getInstance();

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