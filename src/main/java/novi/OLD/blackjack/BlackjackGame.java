package novi.OLD.blackjack;

import com.diogonunes.jcolor.Attribute;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

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
        dealer.addCardsToHand(new Card[]{myDeck.getNextCard()});

        while(true) {
            southands();

            //input: hit or stay
            System.out.println("hit or stay?");
            String hitOrStay = scanner.nextLine().trim();

            //idiot proofing:
            while(!hitOrStay.equals("hit") && !hitOrStay.equals("stay")) {
                System.out.println("That is not a valid entry. \n please type \"hit\" or \"stay\".");
                hitOrStay = scanner.nextLine();
            }
            //player does their move, if >21 -> player lost
            player.performMove(myDeck, hitOrStay);
            if(player.isBust()){
                southands();
                lost();
                return;
            }

            //dealer performs move, if >21 -> player wins
            // also checks is if dealerhand < playerhand when the dealer "stays" -> player wins
            dealer.performMove(myDeck);
            if(dealer.isBust() ||
                    dealer.isStaying() && dealer.getHandValue() < player.getHandValue()){
                southands();
                won();
                return;
            }
            //if playerhand <= delaerhand when the player "stays" -> player lost
            if(player.isStaying() && player.getHandValue() <= dealer.getHandValue()){
                System.out.println();
                southands();
                lost();
                return;
            }


        }
    }

    private void won(){
        System.out.println(colorize("You Won!!!", Attribute.GREEN_TEXT()));
    }
    private void lost(){
        System.out.println(colorize("You lost!!!", Attribute.RED_TEXT()));
    }

    //print the hands of the player and dealer
    private void southands(){
        System.out.println(player.renderHand());
        System.out.println(dealer.renderHand());
    }
}
