package entity.atmmachine;

import entity.cards.Card;
import validation.Checker;
import validation.exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMController {
    public static void checkBalance(Card card, ATM atm) {
        System.out.println("==================Проверка баланса==================");
        System.out.println("На счету: " + atm.showMoney(card));
        System.out.println("===================================================");
    }

    public static void withdrawMoney(Card card, ATM atm, Scanner sc) {
        System.out.println("===================Снятие средств==================");
        try {
            System.out.print("Введите сумму, которую хотите снять: ");
            double sum = sc.nextDouble();
            Checker.validateRangeSum(sum);
            Checker.validateAllRangeSum(card.getBalance() - sum);
            Checker.validateSumForATM(card.getBalance() - sum, ATM.getAllSum());
            atm.getMoney(card, sum);
            ATM.setAllSum(ATM.getAllSum()-sum);
            System.out.println("Списано: " + sum);
            System.out.println("Сумма в банкомате: "+ ATM.getAllSum());
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Введено не числовое значение, попробуйте ещё раз.");
            sc.nextLine();
        } catch (TooBigSumException | TooBigAllSumException | TooSmallSumException | TooSmallAllSumException |
                 TooBigSumForWithdradException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
        System.out.println("===================================================");
    }

    public static void depositMoney(Card card, ATM atm, Scanner sc) {
        System.out.println("=================Пополнение баланса================");
        try {
            System.out.print("Введите сумму, которую хотите положить: ");
            double sum = sc.nextDouble();
            Checker.validateRangeSum(sum);
            Checker.validateAllRangeSum(sum + card.getBalance());
            atm.addMoney(card, sum);
            ATM.setAllSum(ATM.getAllSum()+sum);
            System.out.println("Положено: " + sum);
            System.out.println("Сумма в банкомате: "+ ATM.getAllSum());
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Введено не числовое значение, попробуйте ещё раз.");
            sc.nextLine();
        } catch (TooBigSumException | TooBigAllSumException | TooSmallSumException | TooSmallAllSumException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
        System.out.println("===================================================");
    }
}
