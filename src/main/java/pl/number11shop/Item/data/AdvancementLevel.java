package pl.number11shop.Item.data;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum AdvancementLevel {
    RECREATIONAL("recreational"),
    AMATEUR("amateur"),
    SEMI_PRO("semi-pro"),
    PROFFESIONAL("proffesional");

    private final String value;
    AdvancementLevel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
