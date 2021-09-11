package novi.higherlower;

import java.util.Scanner;
import java.util.Random;

public class HigherLowerGame {
    private final Scanner inputScanner;
    private final boolean devtest = true;
    private int cheatCheck = 0;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        boolean gameIsRunning = true;
        int gamesPlayed = 0;

        // Here you should generate the number to guess
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        randomNumber++;
        devprint(randomNumber);


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
            } while(playerGuess == -1);
            // end loop

            System.out.printf("You typed: %s\n", input);
            gamesPlayed++;

            // Check if the guess is correct, if so end the game
            if(Integer.parseInt(input) > randomNumber){
                System.out.println("That number is too high");
            } else if(Integer.parseInt(input) < randomNumber){
                System.out.println("That number is too low");
            } else {
                System.out.println("Correct! You guessed the number in " + gamesPlayed + " turns");
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
                    randomNumber = rand.nextInt(100);
                    devprint(randomNumber);
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
}