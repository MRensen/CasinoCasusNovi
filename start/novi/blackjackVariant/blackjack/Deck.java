package novi.blackjackVariant.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {

    private int deckSize = 52;
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        final CardSuit[] suits;
        final CardValue[] values;
        suits = new CardSuit[] {
                new CardSuit("diamonds", '\u2666', "red"),
                new CardSuit("spades", '\u2660', "black"),
                new CardSuit("hearts", '\u2665',"red"),
                new CardSuit("clubs",'\u2663',"red")
        };
        values = new CardValue[] {
                new CardValue("one", 1),
                new CardValue("two", 2),
                new CardValue("three", 3),
                new CardValue("four", 4),
                new CardValue("five", 5),
                new CardValue("six", 6),
                new CardValue("seven", 7),
                new CardValue("eight", 8),
                new CardValue("nine", 9),
                new CardValue("ten", 10),
                new CardValue("jack", 10),
                new CardValue("king", 10),
                new CardValue("queen", 10),
        };
        for(CardSuit suit : suits){
            for(CardValue value: values){
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public boolean isEmpty(){
       return cards.isEmpty();
    }

    public Card getNextCard(){
        return cards.remove(0);
    }

    // ik weet niet wat ik met deze functie moet??!!
    private Card[] makeCards(){
        return new Card[0];
    }
}
