package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor
@SuppressWarnings("unused")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomtheme;
    @Column(columnDefinition = "TEXT")
    private String contentTheme;


    @OneToMany(mappedBy = "theme")
    private List<Recherche> recherches;
}
