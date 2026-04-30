package fr.eni.gestionavis.dao;

import fr.eni.gestionavis.bo.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "avis", path = "avis")
public interface AvisRepository extends MongoRepository<Avis,String> {
}
