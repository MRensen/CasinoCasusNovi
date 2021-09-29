package novi.HigherLower;

import com.diogonunes.jcolor.Attribute;
import novi.Game;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

public class HigherLowerGame implements Game {
    private final String name = "HigherLower";
    private final int minimalRequiredCoins = 5;
    private int coins;
    private final Scanner inputScanner;
    private final boolean devtest = true;
    private int cheatCheck = 0;
    private int winnings = 0;
    private IRandomGenerator random;

    public HigherLowerGame(Scanner inputScanner, IRandomGenerator random) {
        this.inputScanner = inputScanner;
        this.random = random;
    }

    public void playGame() {
        boolean gameIsRunning = true;
        int gamesPlayed = 0;

        // Here you should generate the number to guess
        int randomNumber = random.nextInt(100);
        randomNumber++;
        //devprint(randomNumber);
        System.out.println("Guess a number between 0 and 100. You have 10 guesses.");


        while (gameIsRunning) {
            System.out.println("Make a guess");
            String input = inputScanner.nextLine();
            //playerGuess == -1 to check if it is set in the following loop
            int playerGuess = -1;

            // this loop checks if userinput == int
            do {
                try {
                    playerGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That is not a number. Try again:");
                    input = inputScanner.nextLine();
                }
            } while (playerGuess == -1);
            // end loop

            System.out.printf("You typed: %s\n", input);
            gamesPlayed++;
            System.out.println(gamesPlayed);

            // Check if the guess is correct, if so end the game
            if (Integer.parseInt(input) > randomNumber) {
                System.out.println("That number is too high");
            } else if (Integer.parseInt(input) < randomNumber) {
                System.out.println("That number is too low");
            } else if (gamesPlayed >= 10){
                System.out.println("You have made 10 guesses, better luck next time.");
                //reset and replay
                gamesPlayed = 0;
                randomNumber = random.nextInt(100);
                devprint(randomNumber);
                playerGuess = -1;
            } else {
                System.out.println(colorize("Correct! You guessed the number in " + gamesPlayed + " turns", Attribute.GREEN_TEXT()));
                winnings = winnings + (10 - gamesPlayed);
                if(gamesPlayed == 1){
                    cheatCheck ++;
                    if(cheatCheck >= 5){
                        System.out.println("You're too good. You are cheating!!!");
                        cheatCheck = 0;
                    }
                }

                // loop and if checks is input == yes/no than restarts the game (or not)
                while(!input.equals("no") && !input.equals("yes")){
                    System.out.println("Do you want to play again? Type \"yes\" or \"no\"");
                    input = inputScanner.nextLine();
                }
                if(input.equals("no")){
                    //quit
                    return;
                } else {
                    //reset and replay
                    gamesPlayed = 0;
                    randomNumber = random.nextInt(100);
                    //devprint(randomNumber);
                    playerGuess = -1;
                }

            }

        } // end gameloop
    }

    private void devprint(Object print){
        if(devtest) {
            System.out.println("DEVTEST: " + print);
        }
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void playGame(int coins) {
        this.coins = coins -5;
        playGame();

    }

    @Override
    public int getMinimalRequiredCoins() {
        return minimalRequiredCoins;
    }

    @Override
    public int getWinnings() {
        return winnings;
    }
}
