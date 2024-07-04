package managers;

import entity.cards.BuilderCard;
import entity.cards.Card;

import java.util.HashSet;
import java.util.List;

public class ParserManager {

    public static HashSet<Card> convertDataFromFile() {
        HashSet<Card> cards = new HashSet<>();
        HashSet<String> lines = FileManager.readData();
        for (String line : lines) {
            String[] data = line.split(" ");
            if (data.length == 6) {
                cards.add(BuilderCard.buildCard(data));
            }
        }
        return cards;
    }

    public static void convertDataToFile(HashSet<Card> cards) {
        FileManager.writeData(cards);
    }
}
