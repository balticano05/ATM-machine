package exceptions;

public class IncorrectDataFormatInFileException extends RuntimeException {
    public IncorrectDataFormatInFileException(String message){
        super(message);
    }
}
