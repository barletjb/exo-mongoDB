package fr.eni.gestionavis.bo;

import fr.eni.gestionavis.bo.vin.Bouteille;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Document(collection = "gestion_avis")
public class Avis {

    @Id
    private String id;

    @Field(name = "note")
    private int note;

    @Field(name = "commentary")
    private String commentaire;

    @Field(name = "date")
    private LocalDateTime date;

    @Field(name = "client")
    private Client client;

    @DBRef
    @Field(name = "bottle_id")
    private Bouteille bouteille;

}
