package com.PFE.StructureRechercheFST.Services.Enseignant;

import com.PFE.StructureRechercheFST.DAO.RechercheDAO;
import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class RechercheService {

    @Autowired
    RechercheDAO rechercheDAO;

    public void posterUnRecherche(Recherche recherche) {
        rechercheDAO.save(recherche);
    }

}
