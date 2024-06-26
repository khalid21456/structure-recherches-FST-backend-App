package com.PFE.StructureRechercheFST.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
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
    private String tele;
    private String address;
    private Date dateEmbauche;
    private Date dateNaissance;
    private String profile;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
    private List<Publication> publications;

    @OneToMany(mappedBy = "encadrant", cascade = CascadeType.ALL)
    private List<Doctorant> doctorants;

    @ManyToOne
    @JoinColumn(name = "equipe")
    private Equipe equipe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Laboratoire")
    private Laboratoire labo;

    public Enseignant() {
        super();
    }
}
