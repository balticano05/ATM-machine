package utils;

import entity.Card;

import java.time.LocalDateTime;
import java.util.HashSet;


public final class CardStorage {

    private ConfigReader configReader = ConfigReader.getInstance();

    private static CardStorage instance;
    private HashSet<Card> cards;
    private double sumInATM;

    private CardStorage(){}
    {

        sumInATM = configReader.getDoubleValue("sumInATM");

        boolean isUnBlockedCard = false;

        System.out.println("Сумма в банкомате: "+sumInATM);

        cards = ParseManager.convertDataFromFile();

        for (Card card : cards) {

            LocalDateTime cardUnlockDate = card.getUnlockDate();

            if (cardUnlockDate != null  && cardUnlockDate.isBefore(LocalDateTime.now())) {

                card.setUnlockDate(null);

                card.setAttempts((byte) 3);

                card.setBlocked(false);

                isUnBlockedCard = true;
            }
        }
        if(isUnBlockedCard){

            System.out.println("Карточки разблокированы!");
        }
    }

    public Double getSumInATM() {
        return sumInATM;
    }

    public void setSumInATM(Double sumInATM) {
        this.sumInATM = sumInATM;
    }

    public HashSet<Card> getCards() {
        return cards;
    }

    public static CardStorage getInstance() {

        if (instance == null) {

            instance = new CardStorage();
        }

        return instance;
    }
}
