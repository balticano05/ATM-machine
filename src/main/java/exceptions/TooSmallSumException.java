package exceptions;

public class TooSmallSumException extends RuntimeException{
    public TooSmallSumException(String message) {
        super(message);
    }
}
