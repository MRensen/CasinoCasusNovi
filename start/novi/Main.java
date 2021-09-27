package novi;

import java.util.Scanner;

import novi.Hangman.HangmanGame;
import novi.SlotMachines.SlotMachineGame;
import novi.blackjackVariant.blackjack.LowDeckBlackjack;
import novi.higherlower.HigherLowerGame;
import novi.blackjackVariant.blackjack.BlackjackGame;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        Casino casino = new Casino(inputScanner);
        casino.start();

    }
}
