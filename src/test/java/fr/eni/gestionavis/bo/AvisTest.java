package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.dao.AvisRepository;
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
    void test_findAllReviews(){

        Avis avis =  Avis.builder()
                .note(4)
                .commentaire("Deuxième commentaire")
                .date(LocalDateTime.now())
                .build();

        Avis avisDB = avisRepository.save(avis);

        List<Avis> listAvis = avisRepository.findAll();

        Assertions.assertThat(listAvis).hasSize(2);
    }


}