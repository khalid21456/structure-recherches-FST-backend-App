package com.PFE.StructureRechercheFST.Services.Enseignant;

import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class EnseignantService {

    @Autowired
    private PublicationDAO publicationDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;

    public void Publier(Publication publication,Long idPublier) {
        Enseignant enseignant = null;
        if(enseignantDAO.findById(idPublier).isPresent()) {
            enseignant = enseignantDAO.findById(idPublier).get();
        }
        publication.setEnseignant(enseignant);
        publicationDAO.save(publication);
    }


}
