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
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 50;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 100;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 150;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 200;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 250;
        }

        return 0;
    }

    @Override
    public String renderWinningConditions() {
        return "5x star    | 50 tokens\n" + "5x yinyang | 100 tokens\n" + "5x spade   | 150 tokens\n"
                + "5x heart   | 200 tokens\n" + "5x club    | 250 tokens\n";
    }
}
