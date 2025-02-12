package pl.number11shop.Item.data;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @Column(name = "producer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    public Producer(String name) {
        this.name = name;
    }
    public Producer() {}

}
