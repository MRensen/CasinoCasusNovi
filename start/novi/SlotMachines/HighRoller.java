package novi.SlotMachines;

public class HighRoller extends SlotMachine{


    public HighRoller() {
        super("High Roller", 3);
    }

    @Override
    public int getRollPrice() {
        return 10;
    }

    @Override
    public int calculatePayout() {
        return 0;
    }

    @Override
    public int renderWinningConditions() {
        return 0;
    }

}
