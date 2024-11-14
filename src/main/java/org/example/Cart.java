package org.example;

import java.util.ArrayList;

public class Cart {
    private Client client;
    private ArrayList<Item> items;

    public Cart(Client client) {
        this.client = client;
        items = new ArrayList<Item>();
    }
}
