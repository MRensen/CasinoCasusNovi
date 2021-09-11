package novi.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int totalValue;
    private List<Card> cardList;

    public Hand(){
        cardList = new ArrayList<>();
    }

    public void addCard(Card card){
        cardList.add(card);
        totalValue += card.getValue();
    }

    public int getTotalValue(){
        return totalValue;
    }

    public String render(){
        StringBuilder builder = new StringBuilder();
        for(Card card : cardList){
            builder.append(card.render() + ", ");
        }
        return builder.toString();
    }



}
