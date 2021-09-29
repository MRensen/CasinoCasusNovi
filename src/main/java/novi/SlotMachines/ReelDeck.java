package novi.SlotMachines;

import java.util.List;

public class ReelDeck {

    Symbol symbol;

    List<Reel> reels;

    public ReelDeck(List<Reel> reels){
        this.reels = reels;
    }

    public void roll(){
        for(Reel reel: reels){
            reel.roll();
        }
    }

    public String render(){
        StringBuilder builder = new StringBuilder();
        for(Reel reel : reels){
            builder.append(reel.render()+ "|");
        }
        return "|" + builder.toString();
    }

    public boolean allReelsHaveSymbol(Symbol symbol){
        for(Reel reel : reels){
            if(! reel.getSymbol().equals(symbol)){
                return false;
            }
        }
        return true;
    }

}
