package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private ArrayList<Item> items;
    private Client client;
    private TypeOfDelivery deliveryType;
    private LocalDate acceptanceDate;
    private LocalDate shipmentDate;

    public Order(int orderId, ArrayList<Item> items, Client client, TypeOfDelivery deliveryType) {
        this.orderId = orderId;
        this.items = items;
        this.client = client;
        this.deliveryType = deliveryType;
        this.acceptanceDate = LocalDate.now();
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public TypeOfDelivery getDeliveryType() {
        return deliveryType;
    }

    public LocalDate getAcceptanceDate() {
        return acceptanceDate;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public double getDeliveryCost() {
        if(getItemsCost()>=300){
            return 0.0;
        }
        switch (deliveryType) {
            case PaczkomatyInPost -> {
                return 10.00;
            }
            case OdbiórOsobisty -> {
                return 0.00;
            }
            default -> {
                return 20.0;
            }
        }
    }

    public double getItemsCost() {
        double totalPrice = 0;
        double totalDiscount = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
            totalDiscount += item.getDiscountValue();
        }
        return totalPrice - totalDiscount;
    }


}
