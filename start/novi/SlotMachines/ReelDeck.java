package novi.SlotMachines;

import java.util.List;

public class ReelDeck {

    Symbol symbol;

    List<Reel> reels;

    public ReelDeck(List<Reel> reels){
        this.reels = reels;
    }

    public void roll(){

    }

    public String render(){
        return null;
    }

    public Symbol getSymbol(){
        return symbol;
    }

}
