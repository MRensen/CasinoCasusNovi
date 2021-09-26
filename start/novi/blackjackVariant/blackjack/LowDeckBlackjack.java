package novi.blackjackVariant.blackjack;

import novi.Game;

import java.util.Scanner;

public class LowDeckBlackjack extends BlackjackGame implements Game {

    public LowDeckBlackjack (Scanner scanner){

        super(scanner, new LowDeck());
    }

    @Override
    void runGameLoop() {
        playGame();
    }

    //TODO implement Game interface
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void playGame(int coins) {

    }

    @Override
    public int getMinimalRequiredCoins() {
        return 0;
    }

    @Override
    public int getWinnings() {
        return 0;
    }
}
