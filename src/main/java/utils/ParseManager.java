package utils;

import entity.Card;

import java.util.HashSet;
import java.util.Set;

public final class ParseManager {

    private ParseManager() {}

    public static HashSet<Card> convertDataFromFile() {
        HashSet<Card> cards = new HashSet<>();
        HashSet<String> lines = FileManager.readData();
        for (String line : lines) {
            String[] data = line.split(" ");
            if (data.length == 6) {
                cards.add(CardBuilder.build(data));
            }
        }
        return cards;
    }

    public static void convertDataToFile(HashSet<Card> cards) {
        FileManager.writeData(cards);
    }
}
