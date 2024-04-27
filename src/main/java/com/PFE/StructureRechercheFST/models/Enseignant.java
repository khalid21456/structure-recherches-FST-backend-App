package com.PFE.StructureRechercheFST.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity @Data
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String labo;
    private Date dateEmbauche;

    @OneToMany(mappedBy = "enseignant")
    private List<Publication> publications;

}
