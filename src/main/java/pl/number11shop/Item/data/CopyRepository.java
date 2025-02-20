package pl.number11shop.Item.data;

import org.springframework.data.repository.CrudRepository;
import pl.number11shop.Item.data.size.Size;
import pl.number11shop.Order.data.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CopyRepository extends CrudRepository<Copy, UUID> {

    List<Copy> findBySize(String size);

    List<Copy> findByOrder(Order order);

    List<Copy> findByItem(Item item);


}
