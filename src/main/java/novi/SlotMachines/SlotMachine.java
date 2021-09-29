package novi.SlotMachines;

import com.diogonunes.jcolor.AnsiFormat;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public abstract class SlotMachine {
    private String name;
    private int numberOfReels;
    protected ReelDeck reelDeck;

    AnsiFormat colorFormat = new AnsiFormat(MAGENTA_TEXT(), BLUE_BACK(), BOLD());

    public SlotMachine(String name, int numberOfReels) {
        this.name = name;

        List<Reel> reels = new ArrayList<>();
        for(int i = 0; i < numberOfReels; i++){
            reels.add(new Reel());
        }
         this.reelDeck = new ReelDeck(reels);

    }

    public void renderIntro(){
        System.out.println(colorize("$--$--$__| LET'S PLAY |__$--$--$", colorFormat));
        System.out.println(colorize(name, colorFormat));
        System.out.println(colorize("$--$--$__|____________|__$--$--$\n\n",colorFormat));

        System.out.println(colorize("WINNING CONDITIONS\n", colorFormat));
        System.out.println(colorize(renderWinningConditions(), colorFormat));
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
