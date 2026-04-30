package fr.eni.gestionavis.dao;

import fr.eni.gestionavis.bo.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "avis", path = "avis")
public interface AvisRepository extends MongoRepository<Avis,String> {

    List<Avis> findByClientPseudo(String pseudo);
    List<Avis> findByClientQuantiteCommandeeGreaterThan(int quantite);
    List<Avis> findByDateBetween(
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date deb,
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date fin
    );

}
