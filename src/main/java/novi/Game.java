package novi;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public interface Game {
    String getName();
    void playGame(int coins);
    int getMinimalRequiredCoins();
    int getWinnings();

}
