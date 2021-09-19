package novi.SlotMachines;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Symbol {
    STAR('\u2605'), YINYANG('\u262F'), SPADE('\u2664'), HEART('\u2661'), CLUB('\u2667');

    public final char icon;

    private Symbol(char icon) {
        this.icon = icon;
    }


}
