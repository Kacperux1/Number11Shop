package org.example;

public abstract class Item {
    private String name;
    private Producent producent;
    private int discountValue;
    private double price;
    private AdvancementLevel advancementLevel;

    public Item(String name, Producent producent, int discountValue, double price, AdvancementLevel advancementLevel) {
        this.name = name;
        this.producent = producent;
        this.discountValue = discountValue;
        this.price = price;
        this.advancementLevel = advancementLevel;
    }

    public String getName() {
        return name;
    }

    public Producent getProducent() {
        return producent;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public double getPrice() {
        return price;
    }

    public AdvancementLevel getAdvancementLevel() {
        return advancementLevel;
    }

    public abstract String getType();

    public abstract String getSize();
}
