package pl.number11shop.Order.data;

import jakarta.persistence.*;
import lombok.Getter;
import pl.number11shop.Client.data.Client;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private UUID orderId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Client client;
    @Column(name = "confirmation_date")
    private LocalDateTime confirmationDate;
    @Column(name = "shipment_date")
    private LocalDateTime shipmentDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(Client client, LocalDateTime confirmationDate, LocalDateTime shipmentDate, OrderStatus status) {
        this.client = client;
        this.confirmationDate = confirmationDate;
        this.shipmentDate = shipmentDate;
        this.status = status;
    }

    public Order() {

    }

}
