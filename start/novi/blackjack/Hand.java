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
    }

    public int getTotalValue(){

    }

    public String render(){

    }



}
