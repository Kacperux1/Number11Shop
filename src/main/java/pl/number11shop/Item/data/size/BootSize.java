package pl.number11shop.Item.data.size;

import org.apache.commons.lang3.builder.ToStringBuilder;

public enum BootSize implements Size {

    BOOT_SIZE_38(38),
    BOOT_SIZE_38_5(38.5),
    BOOT_SIZE_39(39),
    BOOT_SIZE_39_5(39.5),
    BOOT_SIZE_40(40),
    BOOT_SIZE_40_5(40.5),
    BOOT_SIZE_41(41),
    BOOT_SIZE_41_5(41.5),
    BOOT_SIZE_42(42),
    BOOT_SIZE_42_5(42.5),
    BOOT_SIZE_43(43),
    BOOT_SIZE_43_5(43.5),
    BOOT_SIZE_44(44),
    BOOT_SIZE_44_5(44.5),
    BOOT_SIZE_45(45),
    BOOT_SIZE_45_5(45.5),
    BOOT_SIZE_46(46);

    private final double size;
    BootSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
       return String.valueOf(size);
    }
}

