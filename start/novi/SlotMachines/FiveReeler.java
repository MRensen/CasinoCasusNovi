package novi.SlotMachines;

public class FiveReeler extends SlotMachine{

    public FiveReeler(){
        super("Five Reeler", 5);
    }

    @Override
    public int getRollPrice() {
        return 5;
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
