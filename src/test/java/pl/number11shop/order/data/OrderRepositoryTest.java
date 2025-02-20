package pl.number11shop.order.data;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.number11shop.Client.data.Client;
import pl.number11shop.Client.data.ClientRepository;
import pl.number11shop.Item.data.*;
import pl.number11shop.Order.data.Order;
import pl.number11shop.Order.data.OrderRepository;
import pl.number11shop.Order.data.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private CopyRepository copyRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;

    private final Client client = new Client("john@doe.com", "Steve", "Jobs",
            "123456789", "New Jersey", "Manure Water", "3/4",
            "123-46");

    private final Category categoryShirt = new Category("boots");
    private final Category categoryBoots = new Category("boots");
    private final Producer producer = new Producer("Nike");
    private final Item boots = new Item("Phantom", categoryBoots, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
            producer);
    private final Item shirt = new Item("Air", categoryShirt, BigDecimal.valueOf(99.99), AdvancementLevel.RECREATIONAL,
            producer);

    @Test
    void shouldCreateOrder() {
        //given
        var order = new Order(client, LocalDateTime.now(), null, OrderStatus.CONFIRMED);
        //when
        var savedOrder = orderRepository.save(order).getOrderId();
        var readOrder = orderRepository.findById(savedOrder);
        //then
        assertFalse(readOrder.isEmpty());
        assertEquals("Steve", readOrder.get().getClient().getFirstName());
        assertFalse(LocalDateTime.now().isBefore(readOrder.get().getConfirmationDate()));
    }

    @Test
    void shouldFindOrderByClientsEmail() {
        var order = new Order(client, LocalDateTime.now(), null, OrderStatus.CONFIRMED);
        orderRepository.save(order);
        //then
        var foundOrders =  orderRepository.findByClientsEmail("john@doe.com");
        var foundAbsentOrders =  orderRepository.findByClientsEmail("george@washington.com");
        //then
        assertFalse(foundOrders.isEmpty());
        assertTrue(foundAbsentOrders.isEmpty());
        assertEquals(1, foundOrders.size());
        assertEquals("Steve", foundOrders.getFirst().getClient().getFirstName());
    }



}
