package novi.SlotMachines;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Reel {

    private Symbol displaySymbol;

    //all reels are the same, so why not make them once and for all?!
    static private final List<Symbol> symbols = Arrays.asList(Symbol.values());
    static private final Random random = new Random();
    static private final int size = symbols.size();

    public Reel(){
    }

    public void roll(){
        int nextint = random.nextInt(size);
        displaySymbol = symbols.get(nextint);
    }

    public String render(){
        return Character.toString(displaySymbol.icon);
    }

    public Symbol getSymbol(){
        return displaySymbol;
    }


}
