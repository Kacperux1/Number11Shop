package pl.number11shop.Item.data;


import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private int itemId;
    @Column(name = "model")
    private String model;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "advancement_id", referencedColumnName = "advancement_id")
    private AdvancementLevel advancementLevel;
    @ManyToOne
    @JoinColumn(name ="producer_id", referencedColumnName = "producer_id")
    private Producer producer;

    public Item(String model, Category category, BigDecimal price, AdvancementLevel advancementLevel, Producer producer) {
        this.model = model;
        this.category = category;
        this.price = price;
        this.advancementLevel = advancementLevel;
        this.producer = producer;
    }

    public Item() {

    }
}
