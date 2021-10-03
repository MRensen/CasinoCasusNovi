package novi.Blackjack;

public class Dealer {
    private Hand dealerHand;
    private boolean isStaying;

    public Dealer(){
        dealerHand = new Hand();
    }

    public void performMove(Deck deck){
        if(dealerHand.getTotalValue() >= 17){
            isStaying = true;
        } else {
            addCardsToHand(new Card[]{deck.getNextCard()});
        }
    }

    public void addCardsToHand(Card[] cards){
        for(Card card : cards){
            dealerHand.addCard(card);
        }
    }

    public boolean isStaying(){
        return isStaying;
    }

    public boolean isBust(){
        return getHandValue() > 21;
    }

    public int getHandValue(){
        return dealerHand.getTotalValue();
    }

    public String renderHand(){
        return "Dealer hand: " + dealerHand.render();

    }
}
