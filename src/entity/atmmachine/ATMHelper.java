package entity.atmmachine;

import entity.cards.Card;
import managers.ParserManager;
import validation.Checker;

import java.time.LocalDateTime;
import java.util.Scanner;

import static entity.MenuATM.menuAction;

public class ATMHelper {
    public static void handleCardSession(ATM atm, Scanner sc) {
        while (true) {
            System.out.print("Введите номер карты или 0 для выхода: ");
            String cardNumber = sc.nextLine();
            if (cardNumber.equals("0")) {
                System.out.println("Выход из банкомата.");
                break;
            }
            if (!Checker.validateCardNumber(cardNumber)) {
                System.out.println("Неверный формат карты. Попробуйте ещё раз.");
                continue;
            }

            Card foundCard = ATM.findCard(cardNumber); // Поиск карточки по номеру
            if (foundCard == null) {
                System.out.println("Карта не найдена. Попробуйте вставить снова.");
                continue;
            } else {
                System.out.println("Карточка принята.");
            }

            if (foundCard.isBlocked()) {
                System.out.println("Карточка заблокирована до " + foundCard.getUnlockDateString());
                System.out.println("Выход в меню...");
                break;
            }

            handlePinCodeSession(foundCard, atm, sc);

            if (foundCard.getAttempts() == 0) {
                foundCard.setUnlockDate(LocalDateTime.now().plusDays(1));
                foundCard.setBlocked(true);
                System.out.println("Карточка заблокирована до " + foundCard.getUnlockDateString());
                System.out.println("Выход в меню...");
                break;
            }
        }
        ParserManager.convertDataToFile(ATM.storageCards.getCards());
    }

    private static void handlePinCodeSession(Card foundCard,ATM atm, Scanner sc) {
        while (foundCard.getAttempts() > 0) {
            System.out.println("Количество попыток: " + foundCard.getAttempts());
            System.out.print("Введите пин-код: ");
            String pinCode = sc.nextLine();

            if (pinCode.equals(foundCard.getPin())) {
                System.out.println("Пин-код принят. Доступ разрешен.");
                foundCard.setAttempts((byte) 3);
                menuAction(foundCard, atm);
                break;
            } else {
                System.out.println("Неверный пин-код, попробуйте ещё раз.");
                foundCard.decAttempts();
            }
        }
    }
}
