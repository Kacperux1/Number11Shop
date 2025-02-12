package pl.number11shop.Order.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @Column(name = "status_id")
    private int id;
    @Column(name = "status_name")
    private String status;

    public Status(String status) {
        this.status = status;
    }

    public Status() {

    }

}
