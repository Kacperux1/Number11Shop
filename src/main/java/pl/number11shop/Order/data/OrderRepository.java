package pl.number11shop.Order.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    @Query("""
             Select o from Order o
             where o.client.email = :email
             order by o.client.lastName, o.client.firstName \s
            \s""")
    List<Order> findByClientsEmail(@Param("email") String email);

}
