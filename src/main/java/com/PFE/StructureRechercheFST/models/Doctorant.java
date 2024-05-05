package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor
public class Doctorant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String these;
    private String password;
    private Date date_inscri;
    private String address;

    @ManyToOne
    @JoinColumn(name = "encadrant")
    private Enseignant encadrant;

    @OneToMany(mappedBy = "doctorant")
    private List<Publication> publications;

}
