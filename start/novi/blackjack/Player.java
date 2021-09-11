package novi.blackjack;

public class Player {
    private Hand playerHand;
    private boolean isStaying;

    public Player(){
        playerHand = new Hand();
    }
    public void performMove(Deck deck, String move){

    }

    public void addCardsToHand(Card[] cards){
        for(Card card : cards){
            playerHand.addCard(card);
        }
    }

    public boolean isStaying(){
        return isStaying;

    }

    public boolean isBust(){
        return getHandValue() > 21;
    }

    public int getHandValue(){
        return playerHand.getTotalValue();
    }

    public String renderHand(){
       return "Player hand: " + playerHand.render();
    }

}
