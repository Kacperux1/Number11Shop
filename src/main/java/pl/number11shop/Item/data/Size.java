package pl.number11shop.Item.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @Column(name = "size_id")
    private int sizeId;
    @Column(name = "size")
    private String size;

    public Size(String size) {
        this.size = size;
        this.sizeId = 1;
    }

    public Size() {

    }
}
