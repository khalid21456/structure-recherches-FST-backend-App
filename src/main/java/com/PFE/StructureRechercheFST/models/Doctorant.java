package com.PFE.StructureRechercheFST.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    private String password;
    private Date date_embauche;
    private String address;

//    @OneToMany(mappedBy = "doctorant")
//    @Cascade(CascadeType.ALL)
//    private List<Publication> publications;

}
