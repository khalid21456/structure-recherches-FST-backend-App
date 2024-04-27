package com.PFE.StructureRechercheFST.Services.Enseignant;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnseignantService {

    @Autowired
    private PublicationDAO publicationDAO;

    public void Publier(Publication publication) {
        publicationDAO.save(publication);
    }


}
