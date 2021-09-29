package Novi.HigherLower;

import novi.HigherLower.HigherLowerGame;
import novi.HigherLower.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HigherLowerGameTest {
    HigherLowerGame game;

    @BeforeEach
    void init(){

            }

    @Test
    void getNameShouldReturnHigherLower(){
        game = new HigherLowerGame(new Scanner(System.in), new RandomGenerator());
        assertEquals("HigherLower", game.getName());
    }

    @Test
    void getMinimalRequiredCoinsShouldReturn5(){
        game = new HigherLowerGame(new Scanner(System.in), new RandomGenerator());
        assertEquals(5,game.getMinimalRequiredCoins());
    }

    @Test
    void playGameShould(){

    }


}
