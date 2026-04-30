package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.bo.vin.Bouteille;
import fr.eni.gestionavis.bo.vin.BouteilleId;
import fr.eni.gestionavis.dao.AvisRepository;
import fr.eni.gestionavis.dao.BouteilleRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvisTest {

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    BouteilleRepository bouteilleRepository;

    @Test
    @Order(1)
    void test_saveReview(){

        Avis avis =  Avis.builder()
                .note(5)
                .commentaire("Ceci est un commentaire")
                .date(LocalDateTime.now())
                .build();

        Avis avisDB = avisRepository.save(avis);

        Assertions.assertThat(avisDB).isNotNull();
    }

    @Test
    @Order(2)
    void test_saveReviewWithClient(){

        Client client = Client.builder()
                .pseudo("Gros Désir")
                .quantiteCommandee(10)
                .build();

        Avis avis =  Avis.builder()
                .note(5)
                .commentaire("Ceci est nouveau commentaire")
                .date(LocalDateTime.now())
                .client(client)
                .build();

        Avis avisDB = avisRepository.save(avis);

        Assertions.assertThat(avisDB).isNotNull();
    }

    @Test
    @Order(3)
    void test_saveReviewWithClientAndBottle(){

        List<Bouteille> listBouteille = bouteilleRepository.findAll();

        Assertions.assertThat(listBouteille).isNotEmpty();

        Bouteille bouteille = listBouteille.getFirst();

        Client client = Client.builder()
                .pseudo("Gros Désir2")
                .quantiteCommandee(100)
                .build();

        Avis avis =  Avis.builder()
                .note(4)
                .commentaire("Commentaire")
                .date(LocalDateTime.now())
                .client(client)
                .bouteille(bouteille)
                .build();

        Avis avisDB = avisRepository.save(avis);

        Assertions.assertThat(avisDB).isNotNull();
        Assertions.assertThat(avisDB.getClient()).isNotNull();
        Assertions.assertThat(avisDB.getBouteille()).isNotNull();
        Assertions.assertThat(avisDB.getBouteille().getBouteilleId()).isEqualTo(bouteille.getBouteilleId());


    }



    @Test
    @Order(4)
    void test_findAllReviews(){

        Avis avis =  Avis.builder()
                .note(4)
                .commentaire("Deuxième commentaire")
                .date(LocalDateTime.now())
                .build();

        avisRepository.save(avis);

        List<Avis> listAvis = avisRepository.findAll();

        Assertions.assertThat(listAvis).hasSize(4);
    }




}