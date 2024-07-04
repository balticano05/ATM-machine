package entity;

public class PrintText {
    public static void Logo() {
        System.out.println("---------------------------------------------------");
        System.out.println("|                   ATM-machine                   |");
        System.out.println("---------------------------------------------------");
    }

    public static void Session() {
        System.out.println("---------------------------------------------------");
        System.out.println("| 1. Начать сессию.                               |");
        System.out.println("| 2. Выйти из системы.                            |");
        System.out.println("---------------------------------------------------");
    }

    public static void Menu() {
        System.out.println("---------------------------------------------------");
        System.out.println("| 1. Проверить баланс.                            |");
        System.out.println("| 2. Снять средства с счета.                      |");
        System.out.println("| 3. Пополнить баланс.                            |");
        System.out.println("| 4. Выйти из меню.                               |");
        System.out.println("---------------------------------------------------");
    }
}
