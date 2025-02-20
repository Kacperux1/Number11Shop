package pl.number11shop.item.data;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.number11shop.Client.data.Client;
import pl.number11shop.Client.data.ClientRepository;
import pl.number11shop.Item.data.*;
import pl.number11shop.Item.data.size.BallSize;
import pl.number11shop.Item.data.size.BootSize;
import pl.number11shop.Item.data.size.ClothingSize;
import pl.number11shop.Order.data.Order;
import pl.number11shop.Order.data.OrderRepository;
import pl.number11shop.Order.data.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CopyRepositoryTest {


    @Autowired
    private CopyRepository copyRepository;
    @Autowired
    private ItemRepository itemRepository;

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
    private final Order order = new Order(client, LocalDateTime.now(), null, OrderStatus.CONFIRMED);

    @Test
    void shouldCreateCopy() {
        //given
        var copy = new Copy(boots, BootSize.BOOT_SIZE_44);
        //when
        var copyId = copyRepository.save(copy).getId();
        var createdCopy = copyRepository.findById(copyId);
        //then
        assertTrue(createdCopy.isPresent());
        assertEquals("Phantom", createdCopy.get().getItem().getModel());
    }

    @Test
    void shouldFindCopiesBySize() {
        //given
        copyRepository.save(new Copy(boots, BootSize.BOOT_SIZE_44));
        copyRepository.save(new Copy(shirt, ClothingSize.M));
        //when
        var foundBoots = copyRepository.findBySize(String.valueOf(BootSize.BOOT_SIZE_44));
        var foundShirts = copyRepository.findBySize(String.valueOf(ClothingSize.M));
        var foundAbsentOther = copyRepository.findBySize(String.valueOf(BallSize.BALL_SIZE_5));
        //then
        assertFalse(foundBoots.isEmpty());
        assertFalse(foundShirts.isEmpty());
        assertTrue(foundAbsentOther.isEmpty());
        assertEquals(1, foundShirts.size());
        assertEquals(1, foundBoots.size());
        assertEquals("Nike", foundBoots.getFirst().getItem().getProducer().getName());
        assertEquals(BigDecimal.valueOf(99.99), foundShirts.getFirst().getItem().getPrice());
    }

    @Test
    public void shouldFindCopiesByOrder() {
        //given
        var copy1 = new Copy(boots, BootSize.BOOT_SIZE_44);
        var copy2 = new Copy(shirt, ClothingSize.M);
        var copy3 = new Copy(boots, BootSize.BOOT_SIZE_38);
        //when
        copy1.setOrder(order);
        copy2.setOrder(order);
        copyRepository.save(copy1);
        copyRepository.save(copy2);
        copyRepository.save(copy3);
        //then
        var foundCopies = copyRepository.findByOrder(order);
        assertFalse(foundCopies.isEmpty());
        assertEquals(2, foundCopies.size());
        assertEquals("Nike", foundCopies.getFirst().getItem().getProducer().getName());
        assertEquals("Jobs", foundCopies.getLast().getOrder().getClient().getLastName());
    }

    @Test
    public void shouldFindCopiesByItem() {
        //given
        var copy1 = new Copy(boots, BootSize.BOOT_SIZE_44);
        var copy2 = new Copy(shirt, ClothingSize.M);
        var copy3 = new Copy(boots, BootSize.BOOT_SIZE_38);
        var absentItem = itemRepository.save(new Item("Force", categoryBoots, BigDecimal.valueOf(1234.99), AdvancementLevel.PROFESSIONAL,
                producer));
        //when
        copyRepository.save(copy1);
        copyRepository.save(copy2);
        copyRepository.save(copy3);
        var foundShirts = copyRepository.findByItem(shirt);
        var foundBoots = copyRepository.findByItem(boots);
        var foundAbsentOther = copyRepository.findByItem(absentItem);
        //then
        assertTrue(foundAbsentOther.isEmpty());
        assertFalse(foundShirts.isEmpty());
        assertFalse(foundBoots.isEmpty());
        assertEquals(1, foundShirts.size());
        assertEquals(2, foundBoots.size());
        assertEquals("Nike", foundBoots.getFirst().getItem().getProducer().getName());
        assertEquals(BigDecimal.valueOf(99.99), foundShirts.getLast().getItem().getPrice());
        assertEquals("Air", foundShirts.getFirst().getItem().getModel());
    }


}
