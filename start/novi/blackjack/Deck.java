package novi.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    int deckSize = 52;
    List<Card> cards = new ArrayList<>();
    CardSuit[] suits;
    CardValue[] values;

    public Deck(){
//        int deckMakerIndex = 0;
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
//        Card[] newcards = new Card[52];
//        int randomcounter = deckSize;
//        int newcardcounter = 0;
//        while(randomcounter >=0) {
//            Random random = new Random();
//            int index = random.nextInt(randomcounter);
//            newcards[newcardcounter] = cards[index];
//            cards[index] = null;
//            newcardcounter++;
//            randomcounter--;
//        }
//        cards = newcards;
    }

    public boolean isEmpty(){

    }

    public Card getNextCard(){

    }

    private Card[] makeCards(){

    }
}
