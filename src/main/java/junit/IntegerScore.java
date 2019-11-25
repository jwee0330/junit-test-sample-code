package junit;

public class IntegerScore implements Score {

    private Integer value;

    public IntegerScore(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getSum() {
        return this.value;
    }
}
