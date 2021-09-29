package Novi.HigherLower;

import novi.HigherLower.HigherLowerGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class HigherLowerGameTest {
    HigherLowerGame game;

    @BeforeEach
    void init(){
        game = new HigherLowerGame(new Scanner(System.in));
            }

    @Test
    void getNameShouldReturnHigherLower(){
        assertEquals("HigherLower", game.getName());
    }

    @Test
    void getMinimalREquiredCoinsShouldReturn5(){
        assertEquals(5,game.getMinimalRequiredCoins());
    }


}
