package pl.number11shop.item.data;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.number11shop.Item.data.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private  ItemRepository itemRepository;
    private final Category category = new Category("Boots");
    private final Producer producer = new Producer("Nike");


    @Test
    public void shouldAddItem() {
        //g
        var item =  new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
                producer);
        //w
        var savedItemId = itemRepository.save(item).getItemId();
        var readItem = itemRepository.findById(savedItemId);
        //t
        assertTrue(readItem.isPresent());
        assertEquals("Phantom X 3", readItem.get().getModel());
        assertEquals("Nike", readItem.get().getProducer().getName());
    }

    @Test
    public void shouldFindItemByModel() {
        //g
        var item =  new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
                producer);
        //w
        var readItem = itemRepository.save(item).getItemId();
        var foundItem = itemRepository.findByModel("Phantom X 3");
        //then
        assertFalse(foundItem.isEmpty());
        assertEquals(BigDecimal.valueOf(99.99), foundItem.get().getPrice());
    }

    @Test
    public void shouldNotFindItemByModel() {
        //g
        var item =  itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
                producer));
        //w
        var foundItem = itemRepository.findByModel("Phantom X 3");
        //then
        assertTrue(foundItem.isEmpty());
    }


}
