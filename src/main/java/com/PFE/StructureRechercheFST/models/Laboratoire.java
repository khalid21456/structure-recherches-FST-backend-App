package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@SuppressWarnings("unused")
@Data
@NoArgsConstructor
public class Laboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomLaboratoire;
    private String acronyme;

    @OneToOne
    private Enseignant responsable;

    @OneToMany(mappedBy = "labo")
    private List<Enseignant> membresLabo;
}
