package novi.SlotMachines;

public abstract class SlotMachine {
    String name;
    int numberOfReels;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;
        this.numberOfReels = numberOfReels;
    }

    public void renderIntro(){

    }
    public int roll(){
        return 0;
    }

    public String render(){
        return name;
    }

    public abstract int getRollPrice();

    public abstract int calculatePayout();

    public abstract int renderWinningConditions();

}
