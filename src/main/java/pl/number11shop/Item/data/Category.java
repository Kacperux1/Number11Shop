package pl.number11shop.Item.data;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int categoryId;
    @Column(name = "category_name", nullable = false, length = 30)
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.categoryId = 0;
    }

    public Category() {
    }

}
