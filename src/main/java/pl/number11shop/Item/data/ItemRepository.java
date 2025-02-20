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

    List<Item> findByPriceLessThan(@Param("price") BigDecimal price);

    @Query("""
            select i from Item i
            where i.producer.name=:producer
            """)
    List<Item> findByProducer(@Param("producer") String producer);

    @Query("""
            select i from Item i
            where i.category.categoryName=:category
            """)
    List<Item> findByCategory(@Param("category") String category);

    List<Item> findByAdvancementLevel(AdvancementLevel advancementLevel);
}
