package pl.number11shop.Item.data;


import jakarta.persistence.*;
import lombok.Getter;


import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    //@ColumnDefault("gen_random_uuid()")
    private UUID itemId;
    @Column(name = "model", length = 30)
    private String model;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "advancement", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private AdvancementLevel advancementLevel;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name ="producer_id", referencedColumnName = "producer_id", nullable = false)
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
