package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @Data @NoArgsConstructor @SuppressWarnings("unused")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomEquipe;

    @OneToOne
    private Enseignant responsable;

    @OneToMany(mappedBy = "equipe")
    private List<Enseignant> membres;

    private String acronyme;

}
