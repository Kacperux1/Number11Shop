package pl.number11shop.Item.data;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import pl.number11shop.Item.data.size.Size;
import pl.number11shop.Order.data.Order;

import java.util.UUID;


@Entity
@Table(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "copy_id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", nullable = false)
    private Item item;
    @Column(name = "size", length = 20)
    private String size;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order order;

    public Copy(Item item, Size size, Order order) {
        this.item = item;
        this.size = size.toString();
        this.order = order;
    }

    public Copy() {
    }

    public UUID getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public String getSize() {
        return size;
    }

    public Order getOrder() {
        return order;
    }
}