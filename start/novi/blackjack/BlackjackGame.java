package novi.blackjack;

import java.util.Scanner;
public class BlackjackGame {
    private final Scanner scanner;
    private Deck myDeck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame(Scanner inputScanner){
        this.scanner = inputScanner;
        myDeck = new Deck();
        player = new Player();
        dealer = new Dealer();
    }

    public void playGame(){

    }
}
