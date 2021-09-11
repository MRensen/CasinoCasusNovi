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
        myDeck.shuffle();
        player.addCardsToHand(new Card[]{myDeck.getNextCard(), myDeck.getNextCard()});

        while(!player.isBust()) {
            dealer.addCardsToHand(new Card[]{myDeck.getNextCard()});
            System.out.println(player.renderHand());
            System.out.println(dealer.renderHand());
            System.out.println("hit or stay?");
            String hitOrStay = scanner.nextLine().trim();
            player.performMove(myDeck, hitOrStay);

        }
    }
}
