package novi.Hangman;

import novi.Hangman.Exceptions.DuplicateLetterException;

import java.sql.SQLOutput;
import java.util.*;

public class HangmanGame {

    private final Random random = new Random();
    private final static List<String> WORDS = Arrays.asList("grandmother", "skill", "appearance", "height", "revolution",
            "writer", "economics", "criticism", "preparation", "courage", "childhood", "steak", "night", "importance",
            "discussion", "heart", "drama", "unit", "writing", "concept");
    private final Scanner scanner;
    private String chosenLetter;
    private List<String> guessedLetters = new ArrayList<>();
    private Exception DuplicateLetterException;

    public HangmanGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void playGame(){
        String chosenWord = WORDS.get(random.nextInt(WORDS.size()));
        System.out.println(chosenWord);
        System.out.println("LETS PLAY HANGMAN");
         for(char star : chosenWord.toCharArray()){
             System.out.print("*");
         }
        System.out.println();
       do {
           System.out.println("Vul een letter in");
           chosenLetter = scanner.nextLine();
           if(chosenLetter.length() != 1){
               System.out.println("Dat is niet 1 letter");
           }
           if(hasBeenGuessed(chosenLetter)){
               throw new DuplicateLetterException(chosenLetter);
           }
       }
         while(!(chosenLetter.length()==1));



    }

    private boolean hasBeenGuessed(String letter){
        for(String guess : guessedLetters){
            if (guess.equals(letter)){
                return true;
            }
        }
        return false;
    }
}
