package novi.SlotMachines;

public class Penny extends SlotMachine{

    public Penny() {
        super("Penny", 3);
    }

    @Override
    public int getRollPrice() {
        return 1;
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
