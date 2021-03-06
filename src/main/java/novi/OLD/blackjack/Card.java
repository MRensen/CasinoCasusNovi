package novi.OLD.blackjack;

public class Card {
    private CardSuit suit;
    private CardValue value;

    public Card(CardSuit suit, CardValue value){
        this.suit = suit;
        this.value = value;
    }

    public String render(){
        return value.getName() + " of " + suit.getName();
    }

    public int getValue(){
        return value.getValue();
    }
}
