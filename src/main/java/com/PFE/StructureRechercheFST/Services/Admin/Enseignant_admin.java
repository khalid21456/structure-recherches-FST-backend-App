package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Enseignant_admin {

    @Autowired
    private EnseignantDAO enseignantDAO;

    public void AjouterEnseignant(Enseignant enseignant) {
        enseignant.setDateEmbauche(new Date());
        enseignantDAO.save(enseignant);
    }

    public List<Enseignant> retournerToutEnseignant() {
        List<Enseignant> list = enseignantDAO.findAll();
        List<Publication> pubs;
        Publication tempPub;
        Iterator<Publication> iteratorPubs;
        Iterator<Enseignant> iterator = list.iterator();
        while(iterator.hasNext()) {
            pubs = iterator.next().getPublications();
            iteratorPubs = pubs.iterator();
            while(iteratorPubs.hasNext()) {
                tempPub = iteratorPubs.next();
                tempPub.setEnseignant(null);
                tempPub.setDoctorant(null);
            }

        }
        return list;
    }
}
