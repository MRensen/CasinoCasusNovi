package novi;

import com.diogonunes.jcolor.Attribute;
import novi.Hangman.HangmanGame;
import novi.HigherLower.RandomGenerator;
import novi.SlotMachines.SlotMachineGame;
import novi.Blackjack.LowDeckBlackjack;
import novi.Blackjack.SimpleBlackjack;
import novi.HigherLower.HigherLowerGame;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Casino {
    private int playerCoins;
    private Scanner scanner;
    private boolean playingGame = true;
    Game game;

    public Casino(Scanner scanner) {
        this.scanner=scanner;
        playerCoins = 1000;
    }

    public void start() {
        System.out.println("Welcome to Casino the Golden Triangle");

        while(playingGame) {
            playingGame();
        }
    }

    private void playingGame(){
            String porq = "";
            while(!porq.equals("q") && !porq.equals("p")){
                System.out.println("Press 'p' to play or 'q' to quit");
                porq = scanner.nextLine();
            }
            if(porq.equals("q")){
                playingGame = false;
                return;
            }else {
                System.out.println(colorize("""
                        Enter the number of the game you want to play:\s
                        1: Higher Lower
                        2: Low Deck Blackjack
                        3: Simple Blackjack
                        4: Slot Machine
                        5: Hangman
                        6: Donate 999 coins to charity""", Attribute.RAPID_BLINK(), Attribute.BRIGHT_MAGENTA_TEXT()));
                int gameOfChoice = 0;
                while(gameOfChoice == 0){
                    try{
                        gameOfChoice = scanner.nextInt();
                    } catch(InputMismatchException e){
                        System.out.println("That is not a number");
                    }
                }
                scanner.nextLine(); //omdat nextint niet naar de volgende regel springt
                switch (gameOfChoice){
                    case 1: game = new HigherLowerGame(scanner, new RandomGenerator());
                    if(enoughCoins(game.getMinimalRequiredCoins())) {
                        game.playGame(playerCoins);}
                        break;
                    case 2: game = new LowDeckBlackjack(scanner);
                        if(enoughCoins(game.getMinimalRequiredCoins())) {
                            game.playGame(playerCoins);}
                        break;
                    case 3: game = new SimpleBlackjack(scanner);
                        if(enoughCoins(game.getMinimalRequiredCoins())) {
                            game.playGame(playerCoins);}
                        break;
                    case 4: game = new SlotMachineGame(scanner);
                        if(enoughCoins(game.getMinimalRequiredCoins())) {
                            game.playGame(playerCoins);}
                        break;
                    case 5: game = new HangmanGame(scanner);
                        if(enoughCoins(game.getMinimalRequiredCoins())) {
                            game.playGame(playerCoins);}
                        break;
                    case 6: if(enoughCoins(999)) {
                        playerCoins -= 999;
                    }
                        break;
                    default:
                        System.out.println("'" + gameOfChoice + "' is not a valid answer");
                        break;
                    }
                try {
                    playerCoins = playerCoins + game.getWinnings();
                } catch (NullPointerException e){
                    //do nothing, because this just means gameOfChoice > number of switch cases
                }
                System.out.println("You currently have " + playerCoins + " coins.");
            }
        }


        private boolean enoughCoins(int min){
            boolean check = min<playerCoins;
            if(!check){
                System.out.println("You do not have enough coins");
            }
            return check;
        }

}
