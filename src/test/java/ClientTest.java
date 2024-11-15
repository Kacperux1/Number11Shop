import org.example.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    public void ConstructorTest()
    {
        Client client = new Client(1, "Wiesław", "Puchacki", "123456789", "jp100@hwdp.pl");
        assertEquals(client.getId(), 1);
        assertEquals(client.getFirstName(), "Wiesław");
        assertEquals(client.getLastName(), "Puchacki");
        assertEquals(client.getEmail(), "jp100@hwdp.pl");
        assertEquals(client.getPhoneNumber(), "123456789");
    }
}
