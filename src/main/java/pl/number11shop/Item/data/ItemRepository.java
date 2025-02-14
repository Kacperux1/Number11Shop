package pl.number11shop.Item.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.number11shop.Item.data.size.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {

    Optional<Item> findByModel(String model);

    Optional<List<Item>> findByPriceLessThan(@Param("price") BigDecimal price);

    Optional<List<Item>> findByProducer(Producer producer);

    Optional<List<Item>> findByCategory(Category category);

    Optional<List<Item>> findByAdvancementLevel(AdvancementLevel advancementLevel);
}
