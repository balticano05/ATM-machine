package repository;

import entity.Card;

import static entity.ATM.storageCards;

public class CardFinder {

    public static Card find(String cardNum) {

        for (Card card : storageCards.getCards()) {

            if (card.getCardNumber().equals(cardNum)) {
                return card;
            }
        }

        return null;
    }
}
