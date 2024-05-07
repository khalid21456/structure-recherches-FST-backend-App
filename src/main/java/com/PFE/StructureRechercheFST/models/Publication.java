package com.PFE.StructureRechercheFST.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity @Data
public class Publication {

    @Id
    @GeneratedValue
    private Long id_pub;
    private String titre;
    @Column(columnDefinition = "TEXT")
    private String contenu;
    private Date datePub;
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "enseignant_publier")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "doctorant_publier")
    private Doctorant doctorant;

}
