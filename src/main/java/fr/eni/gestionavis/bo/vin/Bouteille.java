package fr.eni.gestionavis.bo.vin;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Document(collection = "bottle")
public class Bouteille {

    @Id
    @Field(name = "bottle_id")
    private BouteilleId bouteilleId;

    @Field(name = "name")
    @Indexed(unique = true)
    private String nom;


}
