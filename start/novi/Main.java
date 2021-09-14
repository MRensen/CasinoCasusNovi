package novi;

import java.util.Scanner;

import novi.blackjackVariant.blackjack.LowDeckBlackjack;
import novi.higherlower.HigherLowerGame;
import novi.blackjackVariant.blackjack.BlackjackGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        BlackjackGame game = new LowDeckBlackjack(inputScanner);

//        HigherLowerGame game = new HigherLowerGame(inputScanner);

        game.playGame();

    }
}
