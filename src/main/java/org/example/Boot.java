package org.example;

public class Boot extends Item{
    private BootType type;
    private float size;

    public Boot(String name, Producent producent, int discountValue, float price, AdvancementLevel advancementLevel, BootType type, float size) {
        super(name, producent, discountValue, price, advancementLevel);
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
