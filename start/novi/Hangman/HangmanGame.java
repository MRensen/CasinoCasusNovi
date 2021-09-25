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
    private String scannedLetter;
    private char chosenLetter;
    private int wrongGuesses = 0;
    private List<Character> guessedLetters = new ArrayList<>();

    public HangmanGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void playGame(){
        //start het spel
        System.out.println("LETS PLAY HANGMAN");
        //het spel kiest een woord uit de lijst
        String chosenWord = WORDS.get(random.nextInt(WORDS.size()));
        char[] chosenWordArray = chosenWord.toCharArray();
        char[] guessingWordArray = new char[chosenWordArray.length];
        System.out.println(chosenWord);
        //print * voor alle letters in het gekozen woord
         for(int i = 0; i < chosenWordArray.length; i++){
             guessingWordArray[i] = '*';
         }
        printCharArray(guessingWordArray);
        System.out.println();

         //de speler kiest een letter die niet eerder gekozen is
        while(true) {
            System.out.println("Vul een letter in");
            scannedLetter = scanner.nextLine();
            //check of speler een letter in vult en niet een woord (scanner.nextChar() bestaat helaas niet)
            if(scannedLetter.length() != 1){
                System.out.println("Dat is niet 1 letter");
            } else {
                chosenLetter = scannedLetter.charAt(0);
                // check of de letter al eens gekozen is
                if (hasBeenGuessed(chosenLetter)) {
                    throw new DuplicateLetterException(chosenLetter);
                }else{
                    // voeg letter toe aan lijst van gekozen letters?
                    guessedLetters.add(chosenLetter);

                    //zit de letter in het te raden woord?
                        if (goodGuess(chosenWordArray, guessingWordArray)){
                            printCharArray(guessingWordArray);
                        } else {
                            wrongGuesses++;
                            if(wrongGuesses<8) {
                                printImage(ImageFactory.getImage(wrongGuesses));
                                printCharArray(guessingWordArray);
                            } else {
                                System.out.println("You have lost");
                                printCharArray(guessingWordArray);
                                System.out.println(chosenWord);
                                return;
                            }
                        }


                    //check if won or lost or else continue
                    if(haswon(guessingWordArray)){
                        System.out.println("You have won");
                        printCharArray(guessingWordArray);
                        return;
                    } else if(wrongGuesses == 8){
                    }

                }
            }
        }







    }

    private boolean hasBeenGuessed(char letter){
        for(char guess : guessedLetters){
            if (guess == letter){
                return true;
            }
        }
        return false;
    }

    private void printCharArray(char[] charray){
        String word = "";
        for(char letter: charray){
            word += letter;
        }
        System.out.println(word);
    }

    private boolean haswon(char[] guess){
        for(char test : guess){
            if (test == '*'){
                return false;
            }
        }
        return true;
    }

    private boolean goodGuess(char[] charray, char[] endarray){
        boolean bool = false;
        for(int i = 0; i < charray.length; i++) {
            if (charray[i] == chosenLetter) {
                endarray[i] = chosenLetter;
                bool = true;
            }
        }
        return bool;
    }

    private void printImage(List<String> image){
        for(String line : image){
            System.out.println(line);
        }
    }
}
