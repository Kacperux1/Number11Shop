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
        assertTrue(foundClient.isPresent());
        assertEquals("Janusz", foundClient.get().getFirstName());
        assertEquals("Wons", foundClient.get().getLastName());
        assertEquals("123456789", foundClient.get().getPhoneNumber());
    }

    @Test
    public void shouldNotFindClientByEmail() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        var foundClient = clientRepository.findByEmail("beethoven@classic.com");
        //then
        assertTrue(foundClient.isEmpty());

    }

    @Test
    public void shouldFindClientByLastName() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        var foundClient = clientRepository.findByLastName("Wons");
        //then
        assertTrue(foundClient.isPresent());
        assertEquals("Janusz", foundClient.get().getFirstName());
        assertEquals("stachu@jones.com", foundClient.get().getEmail());
    }

    @Test
    public void shouldDeleteClient() {
        //given
        var savedClient = clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
        //when
        clientRepository.delete(savedClient);
        var deletedClient  = clientRepository.findByEmail("stachu@jones.com");
        //then
        assertNull(deletedClient);
    }

    @Test
    public void shouldFindClientByPhoneNumber() {
        //given
       clientRepository.save(new Client("stachu@jones.com", "Janusz", "Wons","123456789", "Warszawa", "Wojska Polskiego",
                "54", "27-570"));
       //when
        var foundClient = clientRepository.findByPhoneNumber("123456789");
        var foundAbsentClient = clientRepository.findByPhoneNumber("987654321");
        //then
        assertTrue(foundClient.isPresent());
        assertFalse(foundAbsentClient.isPresent());
        assertEquals("Janusz", foundClient.get().getFirstName());
        assertEquals("Wons", foundClient.get().getLastName());
    }


}
