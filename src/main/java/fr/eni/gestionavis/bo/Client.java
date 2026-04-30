package fr.eni.gestionavis.bo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Client {

    @Field(name = "login")
    private String pseudo;

    @Field(name = "quantity_odered")
    private int quantiteCommandee;
}
