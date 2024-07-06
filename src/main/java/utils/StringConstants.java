package utils;

public class StringConstants {

    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public static final String REGEX_CARD_NUMBER = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";

    public static final String REGEX_FORMAT_LINE = "^(\\d{4}-\\d{4}-\\d{4}-\\d{4})\\s+(\\d{4})\\s+" +
            "([\\d.]+)\\s+(null|\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2})\\s+(true|false)\\s+(\\d+)$";

    public static final String LOGO =
            "---------------------------------------------------\n"+
            "|                   ATM-machine                   |\n"+
            "---------------------------------------------------\n";

    public static final String SESSION =
            "---------------------------------------------------\n"+
            "| 1. Начать сессию.                               |\n"+
            "| 2. Выйти из системы.                            |\n"+
            "---------------------------------------------------\n";

    public static final String MENU =
            "---------------------------------------------------\n"+
            "| 1. Проверить баланс.                            |\n"+
            "| 2. Снять средства с счета.                      |\n"+
            "| 3. Пополнить баланс.                            |\n"+
            "| 4. Выйти из меню.                               |\n"+
            "---------------------------------------------------";

}
