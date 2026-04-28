package fr.eni.gestionavis.bo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Document(collection = "client")
public class Client {

    @Id
    @Field(name = "login")
    private String pseudo;

    @Field(name = "quantity_odered")
    private int quantiteCommandee;
}
