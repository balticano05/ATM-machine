package service;

import entity.ATM;
import entity.Card;
import utils.Checker;

import java.util.InputMismatchException;
import java.util.Scanner;

import utils.StringConstants;

import static utils.StringConstants.SEPARATOR;

public class ATMServiceImpl implements ATMService {

    private static Scanner sc;

    public ATMServiceImpl(){

        sc = new Scanner(System.in);
    }

    @Override
    public void checkBalance(Card card) {

        System.out.println(StringConstants.TEXT_LABEL_BALANCE);

        System.out.println("На счету: " + ATM.showMoney(card));

        System.out.println(StringConstants.SEPARATOR);
    }

    @Override
    public void withdrawMoney(Card card) {

        System.out.println(StringConstants.TEXT_LABEL_WITH_WITHDRAWAL_OF_FUNDS);

        try {

            double sum = promptForSum("Введите сумму, которую хотите снять: ");

            if (validateWithdrawal(card, sum)) {

                ATM.getMoney(card, sum);

                ATM.setAllSum(ATM.getAllSum() - sum);

                System.out.println("Списано: " + sum);

                System.out.println("Сумма в банкомате: "+ ATM.getAllSum());
            }
        } catch (InputMismatchException e) {
            handleInputMismatchException();
        } catch (Exception e) {
            handleValidationException(e);
        }

        System.out.println(SEPARATOR);
    }


    public void depositMoney(Card card) {

        System.out.println(StringConstants.TEXT_LABEL_REPLENISHMENT);

        try {

            double sum = promptForSum("Введите сумму, которую хотите положить: ");

            if (validateDeposit(card, sum)) {

                ATM.addMoney(card, sum);

                ATM.setAllSum(ATM.getAllSum() + sum);

                System.out.println("Положено: "+ sum);

                System.out.println("Сумма в банкомате: " + ATM.getAllSum());
            }
        } catch (InputMismatchException e) {
            handleInputMismatchException();
        } catch (Exception e) {
            handleValidationException(e);
        }

        System.out.println(StringConstants.SEPARATOR);
    }

    private static double promptForSum(String message) {

        System.out.print(message);

        return sc.nextDouble();
    }

    private static boolean validateWithdrawal(Card card, double sum) throws Exception {

        Checker.validateRangeSum(sum);

        Checker.validateAllRangeSum(card.getBalance() - sum);

        Checker.validateSumForATM(card.getBalance() - sum, ATM.getAllSum());

        return true;
    }

    private static boolean validateDeposit(Card card, double sum) throws Exception {

        Checker.validateRangeSum(sum);

        Checker.validateAllRangeSum(sum + card.getBalance());

        return true;
    }

    private static void handleInputMismatchException() {

        System.out.println("Введено не числовое значение, попробуйте ещё раз.");

        sc.nextLine();
    }

    private static void handleValidationException(Exception e) {

        System.out.println(e.getMessage());

        sc.nextLine();
    }
}