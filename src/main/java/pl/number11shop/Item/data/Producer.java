package pl.number11shop.Item.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @Column(name = "producer_id")
    private int id;
    @Column(name = "name")
    private String name;

    public Producer(String name) {
        this.name = name;
    }
    public Producer() {}

}
