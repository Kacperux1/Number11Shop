import org.example.*;
import org.junit.jupiter.api.Test;

import static org.example.AdvancementLevel.professional;
import static org.example.BootType.FirmGround;
import static org.example.Producent.Nike;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void AddItemTest(){
        Client client = new Client(1, "Wiesław", "Puchacki", "123456789", "jp100@hwdp.pl");
        MainOrderManager manager = new MainOrderManager();
        Cart cart = new Cart(client, manager);
        Item boots = new Boot("cichobiegi",Nike,0, 415.99,  professional, FirmGround,45.5);
        manager.addItem(cart, boots);
        assertEquals(cart.getItems().size(), 1);
        assertEquals(cart.getItems().get(0), boots);
    }
}
