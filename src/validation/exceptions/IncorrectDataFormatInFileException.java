package validation.exceptions;

public class IncorrectDataFormatInFileException extends IllegalArgumentException{
    public IncorrectDataFormatInFileException(String message){
        super(message);
    }
}
