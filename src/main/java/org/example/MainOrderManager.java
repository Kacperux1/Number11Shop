package org.example;

public class MainOrderManager implements CartManager {
    @Override
    public void addItem(Cart cart,Item item) {
        cart.getItems().add(item);
    }

    @Override
    public void removeItem(Cart cart, Item item) {
        cart.getItems().remove(item);
    }
}
