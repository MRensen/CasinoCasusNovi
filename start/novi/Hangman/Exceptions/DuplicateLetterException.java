package novi.Hangman.Exceptions;

public class DuplicateLetterException extends RunTimeException{
    public DuplicateLetterException(char letter){

        super(System.out.println("De letter " + letter + " is al eens geraden"));
    }
}
