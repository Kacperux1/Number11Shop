package pl.number11shop.Client.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
    Client findByLastName(String lastName);
    Client findByEmail(String email);
}
