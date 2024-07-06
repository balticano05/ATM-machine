package utils;

import entity.Card;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class CardBuilder {

    private static final int CARD_NUMBER_INDEX = 0;
    private static final int PIN_INDEX = 1;
    private static final int BALANCE_INDEX = 2;
    private static final int UNLOCK_DATE_INDEX = 3;
    private static final int IS_BLOCKED_INDEX = 4;
    private static final int ATTEMPTS_INDEX = 5;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    private CardBuilder(){}

    public static Card build(String[] val) {

        if (val.length < 6) {

            throw new IllegalArgumentException("Недостаточно данных для создания карты");
        }

        return CardBuilder.build(
                val[CARD_NUMBER_INDEX],
                val[PIN_INDEX],
                Double.parseDouble(val[BALANCE_INDEX]),
                parseLocalDateTime(val[UNLOCK_DATE_INDEX]),
                Boolean.parseBoolean(val[IS_BLOCKED_INDEX]),
                Byte.parseByte(val[ATTEMPTS_INDEX])
        );
    }

    private static LocalDateTime parseLocalDateTime(String dateTime) {

        if (dateTime == null || dateTime.equals("null")) {

            return null;
        }

        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

    public static Card build(String cardNumber, String pin, double balance, LocalDateTime unlockDate,boolean blocked, byte attempts) {

        return new Card(cardNumber, pin, balance, blocked, attempts, unlockDate);
    }
}