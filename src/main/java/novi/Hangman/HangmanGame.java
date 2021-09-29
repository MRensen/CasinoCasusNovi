package novi.Hangman;

import com.diogonunes.jcolor.Attribute;
import novi.Game;
import novi.Hangman.Exceptions.DuplicateLetterException;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class HangmanGame implements Game {
    private final int minimalRequiredCoins = 8;
    private final String name = "Hangman";
    private int playerCoins;
    private int winnings;

    private final static List<String> WORDS = Arrays.asList("grandmother", "skill", "appearance", "height", "revolution",
            "writer", "economics", "criticism", "preparation", "courage", "childhood", "steak", "night", "importance",
            "discussion", "heart", "drama", "unit", "writing", "concept");
    private final Random random = new Random();
    private final Scanner scanner;
    private String scannedLetter;
    private char chosenLetter;
    private int wrongGuesses = 0;
    private List<Character> guessedLetters = new ArrayList<>();
    private char[] chosenWordArray;
    private char[] guessingWordArray;
    private String chosenWord;
    private boolean gameIsOn = true;

    public HangmanGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void playGame() {
        //start het spel
        System.out.println("LETS PLAY HANGMAN");
        //het spel kiest een woord uit de lijst
        chosenWord = WORDS.get(random.nextInt(WORDS.size()));
        chosenWordArray = chosenWord.toCharArray();
        guessingWordArray = new char[chosenWordArray.length];


        //print * voor alle letters in het gekozen woord
        for (int i = 0; i < chosenWordArray.length; i++) {
            guessingWordArray[i] = '*';
        }
        printCharArray(guessingWordArray);
        System.out.println();
        while (gameIsOn) {
            System.out.println("Guess a letter");
            scannedLetter = scanner.nextLine();
            //check of speler een letter in vult en niet een woord (scanner.nextChar() bestaat helaas niet)
            if (scannedLetter.length() != 1) {
                System.out.println("That is not 1 letter");
            } else {
                chosenLetter = scannedLetter.charAt(0);
            }
            try {
                play();
            } catch (DuplicateLetterException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //de speler kiest een letter die niet eerder gekozen is
    private void play() {

        // check of de letter al eens gekozen is
        if (hasBeenGuessed(chosenLetter)) {
            throw new DuplicateLetterException(chosenLetter);

        } else {
            // voeg letter toe aan lijst van gekozen letters?
            guessedLetters.add(chosenLetter);

            //zit de letter in het te raden woord?
            //goed geraden
            if (goodGuess(chosenWordArray, guessingWordArray)) {
                System.out.println("Good guess");
                printCharArray(guessingWordArray);
                System.out.println();
                //check if won or lost or else continue
                if (haswon(guessingWordArray)) {
                    won();
                    gameIsOn = false;
                    return;
                }
                //fout geraden
            } else {
                wrongGuesses++;
                System.out.println("Wrong guess");
                if (wrongGuesses < 8) {
                    printImage(ImageFactory.getImage(wrongGuesses));
                    printCharArray(guessingWordArray);
                    System.out.println();
                } else {
                    lost();
                    System.out.print("You guessed: ");
                    printCharArray(guessingWordArray);
                    System.out.println("You should've guessed: " + chosenWord);
                    gameIsOn = false;
                    return;
                }
            }

        }

    }


    private boolean hasBeenGuessed(char letter) {
        for (char guess : guessedLetters) {
            if (guess == letter) {
                return true;
            }
        }
        return false;
    }

    private void printCharArray(char[] charray) {
        String word = "";
        for (char letter : charray) {
            word += letter;
        }
        System.out.println(word);
    }

    private boolean haswon(char[] guess) {
        for (char test : guess) {
            if (test == '*') {
                return false;
            }
        }
        return true;
    }

    private boolean goodGuess(char[] charray, char[] endarray) {
        boolean bool = false;
        for (int i = 0; i < charray.length; i++) {
            if (charray[i] == chosenLetter) {
                endarray[i] = chosenLetter;
                bool = true;
            }
        }
        return bool;
    }

    private void printImage(List<String> image) {
        for (String line : image) {
            System.out.println(line);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void playGame(int coins) {
        playerCoins = coins;
        playGame();
    }

    @Override
    public int getMinimalRequiredCoins() {
        return minimalRequiredCoins;
    }

    @Override
    public int getWinnings() {
        if(!gameIsOn) {
            return -minimalRequiredCoins + ((8 - wrongGuesses) * 2);
        } else {
            return 0;
        }

    }
    private void won(){
        System.out.println(colorize("You Won!!!", Attribute.GREEN_TEXT()));
    }
    private void lost(){
        System.out.println(colorize("You lost!!!", Attribute.RED_TEXT()));
    }
}
