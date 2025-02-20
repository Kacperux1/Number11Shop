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
    private ItemRepository itemRepository;
    private final Category category = new Category("Boots");
    private final Producer producer = new Producer("Nike");

    @Test
    public void shouldAddItem() {
        //g
        var item = new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
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
        var item = new Item("Phantom X 3", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
                producer);
        //w
        itemRepository.save(item);
        var foundItem = itemRepository.findByModel("Phantom X 3");
        //then
        assertFalse(foundItem.isEmpty());
        assertEquals(BigDecimal.valueOf(99.99), foundItem.get().getPrice());
    }

    @Test
    public void shouldNotFindItemByModel() {
        //g
        itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.PROFESSIONAL,
                producer));
        //w
        var foundItem = itemRepository.findByModel("Phantom X 3");
        //then
        assertTrue(foundItem.isEmpty());
    }

    @Test
    public void shouldFindItemByPriceLesserThan() {
        //g
        itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.AMATEUR,
                producer));
        itemRepository.save(new Item("Mercurial S100", category, BigDecimal.valueOf(987.99), AdvancementLevel.PROFESSIONAL,
                producer));
        itemRepository.save(new Item("Phantom X 3", category, BigDecimal.valueOf(10.99), AdvancementLevel.PROFESSIONAL,
                producer));
        //w
        var foundItem = itemRepository.findByPriceLessThan(BigDecimal.valueOf(100.99));
        //then
        assertFalse(foundItem.isEmpty());
        assertEquals(2, foundItem.size());
        assertEquals(AdvancementLevel.AMATEUR, foundItem.getFirst().getAdvancementLevel());
        assertEquals(BigDecimal.valueOf(10.99), foundItem.getLast().getPrice());

    }

    @Test
    public void shouldFindItemByProducer() {
        final Producer producer2 = new Producer("Adidas");
        //given
        itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(909.99), AdvancementLevel.AMATEUR,
                producer));
        itemRepository.save(new Item("Phantom 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.SEMI_PRO,
                producer));
        itemRepository.save(new Item("Predator XS69", category, BigDecimal.valueOf(909.99), AdvancementLevel.AMATEUR,
                producer2));
        //when
        var foundItems = itemRepository.findByProducer("Nike");
        var foundAdidasItems = itemRepository.findByProducer("Adidas");
        var foundAbsentItems = itemRepository.findByProducer("Puma");
        //then
        assertFalse(foundItems.isEmpty());
        assertFalse(foundAdidasItems.isEmpty());
        assertTrue(foundAbsentItems.isEmpty());
        assertEquals(2, foundItems.size());
        assertEquals(1, foundAdidasItems.size());
        assertEquals(AdvancementLevel.SEMI_PRO, foundItems.getLast().getAdvancementLevel());
        assertEquals(BigDecimal.valueOf(909.99), foundAdidasItems.getFirst().getPrice());
        assertEquals("Tiempo 100", foundItems.getFirst().getModel());
    }

    @Test
    public void shouldFindItemsByCategory () {
        final Category category2 = new Category("Shirt");
        //given
        itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(909.99), AdvancementLevel.AMATEUR,
                producer));
        itemRepository.save(new Item("Phantom 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.SEMI_PRO,
                producer));
        itemRepository.save(new Item("Air 100", category2, BigDecimal.valueOf(9.99), AdvancementLevel.AMATEUR,
                producer));
        //w
        var foundBoots = itemRepository.findByCategory("Boots");
        var foundShirts = itemRepository.findByCategory("Shirt");
        var foundSocks = itemRepository.findByCategory("Socks");
        //t
        assertFalse(foundBoots.isEmpty());
        assertFalse(foundShirts.isEmpty());
        assertTrue(foundSocks.isEmpty());
        assertEquals(2, foundBoots.size());
        assertEquals(1, foundShirts.size());
        assertEquals(AdvancementLevel.AMATEUR, foundBoots.getFirst().getAdvancementLevel());
        assertEquals(BigDecimal.valueOf(99.99), foundBoots.getLast().getPrice());
        assertEquals("Air 100", foundShirts.getFirst().getModel());
    }

    @Test
    public void shouldFindItemsByAdvancementLevel () {
        //given
        itemRepository.save(new Item("Tiempo 100", category, BigDecimal.valueOf(99.99), AdvancementLevel.AMATEUR,
                producer));
        itemRepository.save(new Item("Phantom 100", category, BigDecimal.valueOf(909.99), AdvancementLevel.SEMI_PRO,
                producer));
        itemRepository.save(new Item("Air 100", category, BigDecimal.valueOf(9.99), AdvancementLevel.AMATEUR,
                producer));
        //when
        var foundAmateur = itemRepository.findByAdvancementLevel(AdvancementLevel.AMATEUR);
        var foundSemiPro = itemRepository.findByAdvancementLevel(AdvancementLevel.SEMI_PRO);
        var foundProfessional = itemRepository.findByAdvancementLevel(AdvancementLevel.PROFESSIONAL);
        //then
        assertFalse(foundAmateur.isEmpty());
        assertFalse(foundSemiPro.isEmpty());
        assertTrue(foundProfessional.isEmpty());
        assertEquals(2, foundAmateur.size());
        assertEquals(1, foundSemiPro.size());
        assertEquals("Boots", foundAmateur.getFirst().getCategory().getCategoryName());
        assertEquals(BigDecimal.valueOf(909.99), foundSemiPro.getFirst().getPrice());
        assertEquals("Nike", foundAmateur.getLast().getProducer().getName());

    }

}
