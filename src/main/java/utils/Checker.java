package utils;

import exceptions.*;

import static utils.StringConstants.REGEX_CARD_NUMBER;
import static utils.StringConstants.REGEX_FORMAT_LINE;

public final class Checker {

    private Checker(){}

    public static boolean validateCardNumber(String cardNumber) {
        return cardNumber.matches(REGEX_CARD_NUMBER);
    }

    public static void validateRangeSum(double sum) throws TooBigAllSumException, TooSmallSumException {

        if(sum > 1000000){

            throw new TooBigSumException("Сумма пополнения не должна превышать 1 000 000.");
        }else if(sum <= 0){

            throw new TooSmallSumException("Сумма пополнения должна быть больше 0.");
        }
    }

    public static void validateAllRangeSum(double sum) throws TooBigAllSumException, TooSmallAllSumException {

        if(sum > 10e7){

            throw new TooBigAllSumException("Общая сумма на счету не должна превышать 10^7");
        }else if(sum <= 0){

            throw new TooSmallAllSumException("Общая сумма на счету не может быть отрицательной.");
        }
    }

    public static void validateFormatLine(String line) throws IncorrectDataFormatInFileException {

        if(!line.matches(REGEX_FORMAT_LINE)){

            throw new IncorrectDataFormatInFileException("Неверный формат строки.");
        }
    }

    public static void validateSumForATM(double sum, double sumATM) throws TooBigSumForWithdradException {

        if(sum > sumATM){

            throw new TooBigSumForWithdradException("У банкомата недостаточно средств.");
        }
    }

}
