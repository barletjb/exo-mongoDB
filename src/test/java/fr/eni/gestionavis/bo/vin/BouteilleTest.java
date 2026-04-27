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
        BouteilleId bouteilleId = BouteilleId.builder()
                .idBouteille(2298)
                .idCouleur(1)
                .idRegion(5)
                .build();

        Bouteille bouteille = Bouteille.builder()
                .bouteilleId(bouteilleId)
                .nom("Jus de bagarre")
                .build();

        Bouteille bouteilleDB = bouteilleRepository.save(bouteille);

        log.info(bouteilleDB.toString());

        Assertions.assertNotNull(bouteilleDB);
        Assertions.assertNotNull(bouteilleDB.getBouteilleId());

    }




}