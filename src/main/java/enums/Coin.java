package enums;

public enum Coin {
    COIN_1(1),
    COIN_2(2),
    COIN_5(5),
    COIN_10(10);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
