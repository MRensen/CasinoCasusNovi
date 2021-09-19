package novi.SlotMachines;

import java.util.Scanner;

public class SlotMachineGame {

    int coins;
    SlotMachine machine;
    Scanner scanner;

    public SlotMachineGame(Scanner scanner  ){
        this.scanner = scanner;
        coins = 100;
    }

    public void playGame(){
        System.out.println("Op welke machine wil je spelen?");
        System.out.println("Press 3 for 'Penny', 2 for 'High Roller', 3 for '5-reeler' ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        switch(answer) {
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
        System.out.println("You're playing " + machine.render());
    }
}

