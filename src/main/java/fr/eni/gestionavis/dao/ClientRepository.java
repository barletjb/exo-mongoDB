package fr.eni.gestionavis.dao;

import fr.eni.gestionavis.bo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
