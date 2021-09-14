package novi.blackjackVariant.blackjack;

import java.util.Scanner;

public class LowDeckBlackjack extends BlackjackGame{

    public LowDeckBlackjack (Scanner scanner){

        super(scanner, new LowDeck());
    }

    @Override
    void runGameLoop() {
        playGame();
    }
}
