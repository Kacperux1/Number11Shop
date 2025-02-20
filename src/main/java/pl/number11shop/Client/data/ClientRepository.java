package pl.number11shop.Client.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
    Optional<Client> findByLastName(String lastName);
    Optional<Client> findByEmail(String email);
    Optional<Client> findByPhoneNumber(String phone);
}
