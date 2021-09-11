package novi;

import java.util.Scanner;

import novi.higherlower.HigherLowerGame;
import novi.blackjack.BlackjackGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        BlackjackGame game = new BlackjackGame(inputScanner);

//        HigherLowerGame game = new HigherLowerGame(inputScanner);

        game.playGame();

    }
}
