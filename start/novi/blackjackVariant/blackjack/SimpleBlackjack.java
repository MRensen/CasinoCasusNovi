package novi.blackjackVariant.blackjack;

import java.util.Scanner;

public class SimpleBlackjack extends BlackjackGame{

    public SimpleBlackjack(Scanner scanner){
        super(scanner, new SimpleDeck());
    }

    @Override
    void runGameLoop() {
        playGame();
    }
}
