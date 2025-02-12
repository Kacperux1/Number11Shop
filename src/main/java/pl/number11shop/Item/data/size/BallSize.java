package pl.number11shop.Item.data.size;

public enum BallSize implements Size {

    BALL_SIZE_3(3),
    BALL_SIZE_4(4),
    BALL_SIZE_5(5),
    ;
    private final int size;
    BallSize(int value) {
        this.size = value;
    }

    @Override
    public String toString() {
       return String.valueOf(size);
    }
}
