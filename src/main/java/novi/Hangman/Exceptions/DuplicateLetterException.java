package novi.Hangman.Exceptions;

public class DuplicateLetterException extends RuntimeException{
    public DuplicateLetterException(char letter){
        super("De letter " + letter + " is al eens geraden");
    }
}
