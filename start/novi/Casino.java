package novi;

import novi.Hangman.HangmanGame;
import novi.SlotMachines.SlotMachineGame;
import novi.blackjackVariant.blackjack.LowDeckBlackjack;
import novi.blackjackVariant.blackjack.SimpleBlackjack;
import novi.higherlower.HigherLowerGame;

import java.util.Scanner;

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
                System.out.println("""
                        Enter the number of the game you want to play:\s
                        1: Higher Lower
                        2: Low Deck Blackjack
                        3: Simple Blackjack
                        4: Slot Machine
                        5: Hangman""");
                int gameOfChoice = scanner.nextInt();
                scanner.nextLine(); //omdat nextint niet naar de volgende regel springt
                switch (gameOfChoice){
                    case 1: game = new HigherLowerGame(scanner);
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
                    default:
                        System.out.println("'" + gameOfChoice + "' is not a valid answer");
                        break;
                    }
                playerCoins = playerCoins + game.getWinnings();
                System.out.println("You currently have " + playerCoins + " coins.");
            }
        }

        private boolean enoughCoins(int min){
            return min<playerCoins;
        }

}
