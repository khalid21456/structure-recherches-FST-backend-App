package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@SuppressWarnings("unused")
@Data
@NoArgsConstructor
public class Laboratoire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomLaboratoire;
    private String acronyme;

    @OneToOne
    private Enseignant responsable;

    @OneToMany(mappedBy = "labo",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Enseignant> membresLabo;


    @OneToMany(mappedBy = "laboratoire")
    private List<Theme> themes;
}
