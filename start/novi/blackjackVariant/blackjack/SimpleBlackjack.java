package novi.blackjackVariant.blackjack;

import novi.Game;

import java.util.Scanner;

public class SimpleBlackjack extends BlackjackGame implements Game {
    private final String name = "Simple Blackjack";
    private final int minimalRequiredCoins = 10;

    public SimpleBlackjack(Scanner scanner){
        super(scanner, new SimpleDeck());
    }

    @Override
    void runGameLoop() {
        playGame();
    }

        //TODO implement Game interface
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
