package novi.Blackjack;

import novi.Game;

import java.util.Scanner;

public class LowDeckBlackjack extends BlackjackGame implements Game {
    private final String name = "Low Deck Blackjack";
    private final int minimalRequiredCoins = 20;

    public LowDeckBlackjack (Scanner scanner){

        super(scanner, new LowDeck());
    }

    @Override
    void runGameLoop() {
        playGame();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void playGame(int coins) {
        runGameLoop();
    }

    @Override
    public int getMinimalRequiredCoins() {
        return minimalRequiredCoins;
    }

    @Override
    public int getWinnings() {
        if(haswon()){
            return minimalRequiredCoins * 2;
        } else {
            return -minimalRequiredCoins;
        }
    }
}
