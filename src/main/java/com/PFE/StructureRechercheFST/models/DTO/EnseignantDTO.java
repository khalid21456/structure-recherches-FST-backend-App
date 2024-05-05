package com.PFE.StructureRechercheFST.models.DTO;


import com.PFE.StructureRechercheFST.models.Publication;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor
public class EnseignantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String labo;
    private Date dateEmbauche;
    private List<Publication> publications;
}
