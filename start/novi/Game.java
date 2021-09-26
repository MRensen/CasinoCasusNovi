package novi;

public interface Game {
    String getName();
    void playGame(int coins);
    int getMinimalRequiredCoins();
    int getWinnings();
}
