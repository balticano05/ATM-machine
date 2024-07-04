package entity.cards;

import managers.ConfigReader;
import managers.ParserManager;

import java.time.LocalDateTime;
import java.util.HashSet;

public class StorageCards {
    private static StorageCards instance;
    private HashSet<Card> cards;
    private double sumInATM;

    {
        ConfigReader configReader = new ConfigReader();
        sumInATM = configReader.getDoubleValue();

        boolean isUnBlockedCard = false;
        System.out.println("Сумма в банкомате: "+sumInATM);
        cards = ParserManager.convertDataFromFile();
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

    private StorageCards() {}

    public HashSet<Card> getCards() {
        return cards;
    }

    public static StorageCards getInstance() {
        if (instance == null) {
            instance = new StorageCards();
        }
        return instance;
    }
}
