package entity;

import entity.atmmachine.ATM;
import entity.atmmachine.ATMController;
import entity.cards.Card;
import java.util.Scanner;
import static entity.atmmachine.ATMHelper.*;


public class MenuATM {

    public static void runSession(ATM atm) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            PrintText.Logo();
            PrintText.Session();
            System.out.print("Введите значение: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    handleCardSession(atm, sc);
                    break;
                case "2":
                    System.out.println("Выход из системы...");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

    public static void menuAction(Card card, ATM atm) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            PrintText.Menu();
            System.out.print("Введите значение: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    ATMController.checkBalance(card, atm);
                    break;
                case "2":
                    ATMController.withdrawMoney(card, atm, sc);
                    break;
                case "3":
                    ATMController.depositMoney(card, atm, sc);
                    break;
                case "4":
                    System.out.println("Заберите карточку.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

}