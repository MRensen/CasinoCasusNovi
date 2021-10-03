package novi.Blackjack;

import java.util.ArrayList;

public class LowDeck extends Deck{
     public LowDeck(){

         cards= new ArrayList<>();

         final CardSuit[] suits;
         final CardValue[] values;
         suits = new CardSuit[] {
                 new CardSuit("diamonds", '\u2666', "red"),
                 new CardSuit("spades", '\u2660', "black"),
                 new CardSuit("hearts", '\u2665',"red"),
                 new CardSuit("clubs",'\u2663',"red")
         };
         values = new CardValue[] {
                 new CardValue("two", 2),
                 new CardValue("three", 3),
                 new CardValue("four", 4),
                 new CardValue("five", 5),
                 new CardValue("six", 6)
         };
         for(CardSuit suit : suits){
             for(CardValue value: values){
                 cards.add(new Card(suit, value));
                 cards.add(new Card(suit, value));
                 cards.add(new Card(suit, value));
             }
         }

     }
}
