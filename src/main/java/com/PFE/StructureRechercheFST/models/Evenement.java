package com.PFE.StructureRechercheFST.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Column(columnDefinition = "TEXT")
    private String eventContent;
    private Date dateDebut;
    private Date dateFin;
    private String imagePath;
    private boolean permession;

}
