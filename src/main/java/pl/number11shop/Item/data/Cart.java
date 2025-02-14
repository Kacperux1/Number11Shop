package pl.number11shop.Item.data;

import lombok.Getter;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


@Getter
public class Cart {

    private final UUID cartId;
    private List<Copy> itemsInCart;

    public Cart(UUID cartId) {
        this.cartId = cartId;
        this.itemsInCart = new LinkedList<>();
    }

    public void addItem(Copy copy) {
        itemsInCart.add(copy);
    }

    public void removeItem(Copy copy) {
        itemsInCart.remove(copy);
    }

    public List<Copy> getItemsInCart() {
        return Collections.unmodifiableList(itemsInCart);
    }

    public void clearCart () {
        itemsInCart.clear();
    }

}
