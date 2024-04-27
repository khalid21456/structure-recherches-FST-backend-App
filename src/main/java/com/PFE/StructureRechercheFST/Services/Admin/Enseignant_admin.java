package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Enseignant_admin {

    @Autowired
    private EnseignantDAO enseignantDAO;

    public void AjouterEnseignant(Enseignant enseignant) {
        enseignant.setDateEmbauche(new Date());
        enseignantDAO.save(enseignant);
    }

    public List<Enseignant> retournerToutEnseignant() {
        return enseignantDAO.findAll();
    }

    public void Publier(Publication publication) {

    }
}
