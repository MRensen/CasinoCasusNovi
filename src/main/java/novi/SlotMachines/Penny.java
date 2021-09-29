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
        if (this.reelDeck.allReelsHaveSymbol(Symbol.STAR)) {
            return 5;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.YINYANG)) {
            return 10;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.SPADE)) {
            return 15;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.HEART)) {
            return 20;
        }

        if (this.reelDeck.allReelsHaveSymbol(Symbol.CLUB)) {
            return 25;
        }

        return 0;
    }

    @Override
    public String renderWinningConditions() {
        return "3x star    | 5 tokens\n" + "3x yinyang | 10 tokens\n" + "3x spade   | 15 tokens\n"
                + "3x heart   | 20 tokens\n" + "3x club    | 25 tokens\n";
    }
}
