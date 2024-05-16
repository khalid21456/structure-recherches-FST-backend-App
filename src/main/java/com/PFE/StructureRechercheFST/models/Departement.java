package com.PFE.StructureRechercheFST.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity @Data @SuppressWarnings("unused") @NoArgsConstructor
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDeparetment;


//    @OneToMany(mappedBy = "departement")
//    private List<Enseignant> enseignants;
}
