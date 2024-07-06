package utils;

import entity.Card;

import java.util.HashSet;

public final class ParserManager {

    private ParserManager() {}

    public static HashSet<Card> convertDataFromFile() {
        HashSet<Card> cards = new HashSet<>();
        HashSet<String> lines = FileManager.readData();
        for (String line : lines) {
            String[] data = line.split(" ");
            if (data.length == 6) {
                cards.add(BuilderCard.build(data));
            }
        }
        return cards;
    }

    public static void convertDataToFile(HashSet<Card> cards) {
        FileManager.writeData(cards);
    }
}
