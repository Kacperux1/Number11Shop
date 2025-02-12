package pl.number11shop.client.data;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.number11shop.Client.data.Client;
import pl.number11shop.Client.data.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void shouldSaveClient() {
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        assertNotNull(savedClient);
    }

    @Test
    public void shouldFindClientByEmail() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        var foundClient = clientRepository.findByEmail("stachu@jones.com");
        //then
        assertNotNull(foundClient);
        assertEquals("Janusz", foundClient.getFirstName());
        assertEquals("Wons", foundClient.getLastName());
        assertEquals("123456789", foundClient.getPhoneNumber());
    }

    @Test
    public void shouldNotFindClientByEmail() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        var foundClient = clientRepository.findByEmail("beethoven@classic.com");
        //then
        assertNull(foundClient);

    }

    @Test
    public void shouldFindClientByLastName() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        var foundClient = clientRepository.findByLastName("Wons");
        //then
        assertNotNull(foundClient);
        assertEquals("Janusz", foundClient.getFirstName());
        assertEquals("stachu@jones.com", foundClient.getEmail());
    }

    @Test
    public void shouldDeleteClient() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        clientRepository.delete(savedClient);
        var deletedClient  = clientRepository.findByEmail("stachu@jones.com");
        assertNull(deletedClient);
    }
}
