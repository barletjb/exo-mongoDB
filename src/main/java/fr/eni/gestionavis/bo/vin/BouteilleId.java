package fr.eni.gestionavis.bo.vin;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class BouteilleId {

    @Field(name = "bottle_id")
    private int idBouteille;

    @Field(name = "region_id")
    private int idRegion;

    @Field(name = "color_id")
    private int idCouleur;
}
