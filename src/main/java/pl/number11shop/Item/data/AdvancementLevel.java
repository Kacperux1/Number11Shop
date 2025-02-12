package pl.number11shop.Item.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "advancement_levels")
public class AdvancementLevel {

    @Id
    @Column(name = "advancement_id")
    private int advancementId;
    @Column(name = "level")
    private String level;

    public AdvancementLevel(String level) {
        this.level = level;
        this.advancementId = 0;
    }

    public AdvancementLevel() {}
}
