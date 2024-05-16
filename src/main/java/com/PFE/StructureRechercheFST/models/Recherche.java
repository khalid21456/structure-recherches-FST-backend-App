package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @Data @NoArgsConstructor
@SuppressWarnings("unused")
public class Recherche implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    @ManyToOne
    @JoinColumn(name = "theme")
    private Theme theme;

    @OneToMany(mappedBy = "these")
    private List<Doctorant> candidat;
}
