package com.PFE.StructureRechercheFST.EnseignantTests;

import com.PFE.StructureRechercheFST.models.Enseignant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("unused")
public class EnseignantTest {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Enseignant enseignant = Enseignant.builder()
                .nom("Ahdoud")
                .prenom("Abdlmonaim")
                .labo("Informatique décisionnel")
                .password("I love Assia")
                .dateEmbauche(new Date())
                .email("Monaim@gmail.com")
                .build();
        String s = objectMapper.writeValueAsString(enseignant);
        assertThat(s).isEqualTo("{\"id\":null,\"nom\":\"Ahdoud\",\"prenom\":\"Abdlmonaim\",\"email\":\"Monaim@gmail.com\",\"password\":\"I love Assia\",\"labo\":\"Informatique décisionnel\",\"dateEmbauche\":1714322474348,\"publications\":null}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException {
        String json = "{\"id\":null,\"nom\":\"Ahdoud\",\"prenom\":\"Abdlmonaim\",\"email\":\"Monaim@gmail.com\",\"password\":\"I love Assia\",\"labo\":\"Informatique décisionnel\",\"dateEmbauche\":1714322474348,\"publications\":null}";
        Enseignant enseignant = Enseignant.builder()
                .nom("Ahdoud")
                .prenom("Abdlmonaim")
                .labo("Informatique décisionnel")
                .password("I love Assia")
                .dateEmbauche(new Date())
                .email("Monaim@gmail.com")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        Enseignant result = objectMapper.readValue(json,Enseignant.class);
        assertThat(result).isEqualTo(enseignant);
    }
}
