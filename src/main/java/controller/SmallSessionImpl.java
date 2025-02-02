package controller;

import entity.ATM;
import entity.Card;
import repository.CardFinder;
import utils.Checker;
import utils.ParseManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SmallSessionImpl implements SmallSession {

    private static Scanner sc;

    public SmallSessionImpl(){
        this.sc = new Scanner(System.in);
    }

    @Override
    public void handleCardSession() {

        boolean isRunning = true;

        while (isRunning) {

            System.out.print("Введите номер карты или 0 для выхода: ");
            String cardNumber = sc.nextLine();

            if (isExit(cardNumber)) break;

            if (!isValidCardNumber(cardNumber)) continue;

            Card foundCard = CardFinder.find(cardNumber);

            if (!isCardFound(foundCard)) continue;

            if (isCardBlocked(foundCard)) break;

            handlePinCodeSession(foundCard);

            if (isCardBlockedAfterAttempts(foundCard)) break;
        }

        ParseManager.convertDataToFile(ATM.storageCards.getCards());
    }

    private static boolean isExit(String cardNumber) {

        if (cardNumber.equals("0")) {

            System.out.println("Выход из банкомата.");

            return true;
        }

        return false;
    }


    private static boolean isValidCardNumber(String cardNumber) {

        if (!Checker.validateCardNumber(cardNumber)) {

            System.out.println("Неверный формат карты. Попробуйте ещё раз.");

            return false;
        }

        return true;
    }

    private static boolean isCardFound(Card foundCard) {

        if (foundCard == null) {

            System.out.println("Карта не найдена. Попробуйте вставить снова.");

            return false;
        } else {

            System.out.println("Карточка принята.");

            return true;
        }
    }

    private static boolean isCardBlocked(Card foundCard) {

        if (foundCard.isBlocked()) {

            System.out.println("Карточка заблокирована до " + foundCard.getUnlockDateString());

            System.out.println("Выход в меню...");

            return true;
        }

        return false;
    }

    private static boolean isCardBlockedAfterAttempts(Card foundCard) {

        if (foundCard.getAttempts() == 0) {

            foundCard.setUnlockDate(LocalDateTime.now().plusDays(1));

            foundCard.setBlocked(true);

            System.out.println("Карточка заблокирована до " + foundCard.getUnlockDateString());

            System.out.println("Выход в меню...");

            return true;
        }

        return false;
    }

    @Override
    public void handlePinCodeSession(Card foundCard) {

        while (foundCard.getAttempts() > 0) {

            printAttempts(foundCard);

            String pinCode = promptForPinCode();

            if (isPinCodeCorrect(foundCard, pinCode)) {

                grantAccess(foundCard);

                break;

            } else {

                handleIncorrectPinCode(foundCard);
            }
        }
    }

    private static void printAttempts(Card foundCard) {

        System.out.println("Количество попыток: " + foundCard.getAttempts());
    }

    private static String promptForPinCode() {

        System.out.print("Введите пин-код: ");

        return sc.nextLine();
    }

    private static boolean isPinCodeCorrect(Card foundCard, String pinCode) {

        return pinCode.equals(foundCard.getPin());
    }

    private static void grantAccess(Card foundCard) {

        System.out.println("Пин-код принят. Доступ разрешен.");

        foundCard.setAttempts((byte) 3);

        ATMMenu atmMenu = new ATMMenu();

        atmMenu.menuAction(foundCard);
    }

    private static void handleIncorrectPinCode(Card foundCard) {

        System.out.println("Неверный пин-код, попробуйте ещё раз.");

        foundCard.decAttempts();
    }
}

