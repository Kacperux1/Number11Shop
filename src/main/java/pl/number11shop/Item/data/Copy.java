package pl.number11shop.Item.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import pl.number11shop.Item.data.size.Size;
import pl.number11shop.Order.data.Order;

import java.util.UUID;

@Getter
@Entity
@Table(name = "copies")
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "copy_id", nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", nullable = false)
    private Item item;
    @Column(name = "size", length = 20)
    private String size;
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    public Copy(Item item, Size size) {
        this.item = item;
        this.size = size.toString();
        this.order = null;
    }

    public Copy() {
    }

}