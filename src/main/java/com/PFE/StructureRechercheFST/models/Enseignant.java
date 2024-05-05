package com.PFE.StructureRechercheFST.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity @Data @AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    //@JsonProperty("firstName")  Renommer la proprité Json
    private String prenom;
    private String email;
    private String password;
    private String labo;
    private Date dateEmbauche;

    @OneToMany(mappedBy = "enseignant")
    private List<Publication> publications;

    @OneToMany(mappedBy = "encadrant")
    private List<Doctorant> doctorants;

    public Enseignant() {
        super();
    }
}
