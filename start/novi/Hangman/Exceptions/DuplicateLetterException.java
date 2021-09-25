package novi.Hangman.Exceptions;

public class DuplicateLetterException extends RunTimeException{
    public DuplicateLetterException(char letter){
        System.out.println("De letter " + letter + " is al eens geraden");
    }
}
