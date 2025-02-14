package pl.number11shop.item.data;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.number11shop.Item.data.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private  ItemRepository itemRepository;
    private final Category category = new Category("Boots");
    private final Producer producer = new Producer("Nike");


    @Test
    public void shouldAddItem() {
        //g
        var item =  new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFFESIONAL,
                producer);
        //w
        var readItem = itemRepository.save(item);
        //t
        assertNotNull(readItem);
        assertEquals("Phantom X 3", readItem.getModel());
        assertEquals("Nike", readItem.getProducer().getName());
    }

    @Test
    public void shouldFindItemByModel() {
        //g
        var item =  new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFFESIONAL,
                producer);
        //w
        var readItem = itemRepository.save(item).getItemId();
        var foundItem = itemRepository.findByModel("Phantom X 3");
        //then
        assertNotNull(foundItem);

    }
}
