package entity.cards;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BuilderCard {
    public static Card buildCard(String[] val){
        return Card.buildCard(val[0],
                val[1],
                Double.parseDouble(val[2]),
                parseLocalDateTime(val[3]),
                Boolean.parseBoolean(val[4]),
                Byte.parseByte(val[5]));
    }

    private static LocalDateTime parseLocalDateTime(String dateTime) {
        if (dateTime == null || dateTime.equals("null")) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(dateTime, formatter);
    }
}