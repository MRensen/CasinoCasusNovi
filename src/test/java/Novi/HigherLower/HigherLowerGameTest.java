package Novi.HigherLower;

import novi.HigherLower.HigherLowerGame;
import novi.HigherLower.IRandomGenerator;
import novi.HigherLower.MockRandomGenerator;
import novi.HigherLower.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HigherLowerGameTest {
    HigherLowerGame game;

    private void init(){
        game = new HigherLowerGame(new Scanner(System.in),  new RandomGenerator());
            }
    private void initMock(InputStream inputStream){
        System.setIn(inputStream);
        game = new HigherLowerGame(new Scanner(System.in), new MockRandomGenerator());
    }
    private void setIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
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

    //edge cases: 10/9/1/0/-1/-10/-20
    @Test
    void winIn10ShouldReturn0(){

        initMock();

    }

    @Test
    void getWinningsShouldReturnEdgeCases(){
        //edge cases: 10/9/1/0/-1/-10/-20

    }


}
