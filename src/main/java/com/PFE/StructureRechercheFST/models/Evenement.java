package com.PFE.StructureRechercheFST.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;

@Entity @Data @NoArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Date dateDebut;
    private Date dateFin;
    private String imagePath;
    private boolean permession;
    private String siteweb;
    private String lieu;
    @ManyToOne
    @JoinColumn(name = "enseignant_publier")
    @Cascade(CascadeType.ALL)
    private Enseignant enseignant;

}
