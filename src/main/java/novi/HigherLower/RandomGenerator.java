package novi.HigherLower;

import java.util.Random;

public class RandomGenerator implements IRandomGenerator{
    Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    @Override
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
