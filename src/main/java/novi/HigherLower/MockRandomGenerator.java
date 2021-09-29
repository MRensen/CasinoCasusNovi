package novi.HigherLower;

public class MockRandomGenerator implements IRandomGenerator{
    private int value;
    public MockRandomGenerator() {
        value = 50;
    }

    @Override
    public int nextInt(int bound) {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
