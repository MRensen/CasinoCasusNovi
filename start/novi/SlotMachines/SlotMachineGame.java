package novi.SlotMachines;

import novi.Game;

import java.util.Scanner;

public class SlotMachineGame implements Game {

    private int coins;
    private SlotMachine machine;
    private Scanner scanner;

    public SlotMachineGame(Scanner scanner  ){
        this.scanner = scanner;
        coins = 100;
    }

    public void playGame(){
        while(true) {
            System.out.println("Op welke machine wil je spelen?");
            System.out.println("Press 1 for 'Penny', 2 for 'High Roller', 3 for 'Five-reeler' ");
            int answer = scanner.nextInt();
            scanner.nextLine();
            switch (answer) {
                case 2:
                    machine = new HighRoller();
                    break;
                case 1:
                    machine = new Penny();
                    break;
                case 3:
                    machine = new FiveReeler();
                    break;
                default:
                    System.out.println("command not recognized. \nSwitching to default: \"Penny\"");
                    machine = new Penny();
            }
            if (machine.getRollPrice() <= coins) {
                machine.renderIntro();
                machine.roll();

                //wait animation
                try {
                    System.out.print("Rolling");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    System.out.println();
                } catch(InterruptedException e){
                    System.out.println("interrupted");
                }
                System.out.println(machine.render());
                coins += (machine.calculatePayout() - machine.getRollPrice());
                System.out.println("coins: " + coins);
                if(machine.getRollPrice() <= coins){
                    System.out.println("Do you want to play again?");
                    String yesno = scanner.nextLine();
                    while(!yesno.equals("yes") && !yesno.equals("no")){
                        System.out.println("Do you want to play again? yes or no?");
                        yesno = scanner.nextLine();
                    }
                    if(yesno.equals("no")){
                        return;
                    }
                }
            } else {
                System.out.println("You do not have enough coins.");
                System.out.println("You need: " + machine.getRollPrice());
                System.out.println("You have: " + coins);
            }
        }
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

