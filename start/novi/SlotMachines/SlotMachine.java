package novi.SlotMachines;

import java.util.ArrayList;
import java.util.List;

public abstract class SlotMachine {
    private String name;
    private int numberOfReels;
    protected ReelDeck reelDeck;

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;

        List<Reel> reels = new ArrayList<>();
        for(int i = 0; i < numberOfReels; i++){
            reels.add(new Reel());
        }
         this.reelDeck = new ReelDeck(reels);

    }

    public void renderIntro(){
        System.out.println("$--$--$__| LET'S PLAY |__$--$--$");
        System.out.println(name);
        System.out.println("$--$--$__|____________|__$--$--$\n\n");

        System.out.println("WINNING CONDITIONS\n");
        System.out.println(renderWinningConditions());
    }
    public int roll(){
        reelDeck.roll();
        return calculatePayout();
    }

    public String render(){
        return reelDeck.render();
    }

    public abstract int getRollPrice();

    public abstract int calculatePayout();

    public abstract String renderWinningConditions();

}
