package novi.HigherLower;

public class MockRandomGenerator implements IRandomGenerator{



    public MockRandomGenerator() {
    }
    @Override
    public int nextInt(int bound) {
        return 50;
    }

}
