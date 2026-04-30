package fr.eni.gestionavis.bo.vin;

import fr.eni.gestionavis.dao.BouteilleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
class BouteilleTest {

    @Autowired
    private BouteilleRepository bouteilleRepository;

    @Test
    void test01_save(){

        Bouteille bouteille = Bouteille.builder()
                .region("Loire")
                .couleur("Du red qui tache")
                .nom("Jus de bagarre2")
                .build();

        Bouteille bouteilleDB = bouteilleRepository.save(bouteille);

        log.info(bouteilleDB.toString());

        Assertions.assertNotNull(bouteilleDB);
        Assertions.assertNotNull(bouteilleDB.getId());

    }

}