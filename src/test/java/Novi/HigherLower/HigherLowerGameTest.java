package Novi.HigherLower;

import novi.HigherLower.HigherLowerGame;
import novi.HigherLower.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class HigherLowerGameTest {
    HigherLowerGame game;

    private void init(){
        game = new HigherLowerGame(new Scanner(System.in), new RandomGenerator());
            }

    @Test
    void getNameShouldReturnHigherLower(){
        init();
        assertEquals("HigherLower", game.getName());
    }

    @Test
    void getMinimalREquiredCoinsShouldReturn5(){
        init();
        assertEquals(5,game.getMinimalRequiredCoins());
    }


}
