package org.example;

public class Ball extends Item{
    private int size;
    private BallType type;

    public Ball(String name, Producent producent, int discountValue, float price, AdvancementLevel advancementLevel, int size, BallType type) {
        super(name, producent, discountValue, price, advancementLevel);
        this.size = size;
        this.type = type;
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    public String getSize() {
        return Integer.toString(size);
    }
}
