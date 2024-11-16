package org.example;

public class Boot extends Item{
    private BootType type;
    private double size;

    public Boot(int id, String name, Producent producent, int discountValue, double price, AdvancementLevel advancementLevel, BootType type, double size) {
        super(id, name, producent, discountValue, price, advancementLevel);
        this.type = type;
        this.size = size;
    }

    @Override
    public String getType() {
        return String.valueOf(type);
    }


    @Override
    public String getSize() {
        return String.valueOf(size);
    }
}
