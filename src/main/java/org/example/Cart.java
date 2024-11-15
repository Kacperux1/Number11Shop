package org.example;

import java.util.ArrayList;

public class Cart {
    private Client client;
    private ArrayList<Item> items;
    private CartManager manager;
    private boolean confirmed;

    public Cart(Client client, CartManager manager) {
        this.client = client;
        items = new ArrayList<Item>();
        this.manager = manager;
        confirmed = false;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public CartManager getManager() {
        return manager;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
    public void confirm() {
        confirmed = true;
    }
}
