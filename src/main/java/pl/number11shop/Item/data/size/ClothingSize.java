package pl.number11shop.Item.data.size;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum ClothingSize implements Size{

    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL");

    private final String value;
    ClothingSize(String val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
