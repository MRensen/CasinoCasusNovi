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
    private void initMock(String inputStream){
        System.setIn(new ByteArrayInputStream(inputStream.getBytes()));
        // MockRandomGenerator is not actually random. Constant value is set in the constructor;
        game = new HigherLowerGame(new Scanner(System.in), new MockRandomGenerator());
    }

    @Test
    void getNameShouldReturnHigherLower(){
        init();
        assertEquals("HigherLower", game.getName());
    }

    @Test
    void getMinimalRequiredCoinsShouldReturn5(){
        init();
        assertEquals(5,game.getMinimalRequiredCoins());
    }

    //edge cases: winnings = 10/1/0/-1
    @Test
    void winIn1ShouldReturn10(){
        String input ="50\nno";
        initMock(input);
        game.playGame();
        assertEquals(10,game.getWinnings());

    }
    // this test is extra and mostly for shits and giggles
    @Test
    void winIn100ShouldReturnMin89(){
        String input = "100\n";
        for(int i = 0; i <= 48;i++){
            input += i + "\n" + (51 + i) + "\n";
        }
        input += "50\nno";
        initMock(input);
        game.playGame();
        assertEquals(-89, game.getWinnings());
    }
    @Test
    void winIn12ShouldReturnMin1(){
        String input = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n50\nno";
        initMock(input);
        game.playGame();
        assertEquals(-1, game.getWinnings());

    }
    @Test
    void winIn11ShouldReturn0(){
        String input = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n50\nno";
        initMock(input);
        game.playGame();
        assertEquals(0, game.getWinnings());

    }
    @Test
    void winIn10ShouldReturn1(){
        String input = "1\n2\n3\n4\n5\n6\n7\n8\n9\n50\nno";
        initMock(input);
        game.playGame();
        assertEquals(1, game.getWinnings());

    }


}
