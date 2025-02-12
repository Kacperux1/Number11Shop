package pl.number11shop.Order.data;

public enum OrderStatus {

    CONFIRMED("confirmed"),
    SHIPPED("shipped"),
    COMPLETED("completed"),
    CANCELED("canceled");

    private final String value;

    OrderStatus(String status) {
        this.value = status;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
