package validation;

import validation.exceptions.*;

public class Checker {

    public static boolean validateCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}");
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
        String regex = "^(\\d{4}-\\d{4}-\\d{4}-\\d{4})\\s+(\\d{4})\\s+([\\d.]+)\\s+(null|\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2})\\s+(true|false)\\s+(\\d+)$";
        if(!line.matches(regex)){
            throw new IncorrectDataFormatInFileException("Неверный формат строки.");
        }
    }

    public static void validateSumForATM(double sum, double sumATM) throws TooBigSumForWithdradException {
        if(sum > sumATM){
            throw new TooBigSumForWithdradException("У банкомата недостаточно средств.");
        }
    }

}
