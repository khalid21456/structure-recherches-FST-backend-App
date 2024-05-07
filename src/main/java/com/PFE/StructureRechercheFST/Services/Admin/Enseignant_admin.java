package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.Services.RandomPasswordGenerator;
import com.PFE.StructureRechercheFST.models.DTO.EnseignantName;
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

    @Autowired
    private RandomPasswordGenerator randomPasswordGenerator;

    public List<Enseignant> AjouterEnseignant(Enseignant enseignant) {
        enseignant.setDateEmbauche(new Date());
        enseignant.setPassword(randomPasswordGenerator.generatePassword(10));
        enseignantDAO.save(enseignant);
        return enseignantDAO.findAll();
    }

    public List<Enseignant> retournerToutEnseignant() {
        List<Enseignant> list = enseignantDAO.findAll();
        Enseignant tempEns = null;
        List<Publication> pubs;
        Publication tempPub;
        Iterator<Publication> iteratorPubs;
        Iterator<Enseignant> iterator = list.iterator();
        while(iterator.hasNext()) {
            tempEns = iterator.next();
            tempEns.setDoctorants(null);
            pubs = tempEns.getPublications();
            iteratorPubs = pubs.iterator();
            while(iteratorPubs.hasNext()) {
                tempPub = iteratorPubs.next();
                tempPub.setEnseignant(null);
                tempPub.setDoctorant(null);
            }
        }
        return list;
    }

    public void modifierEnseignant(Enseignant enseignant,Long id) {

    }

    public int countEnseignants() {
        List<Enseignant> enseignants = enseignantDAO.findAll();
        return enseignants.size();
    }

    public List<Enseignant> supprimerEnseignant(Long id) {
        enseignantDAO.deleteById(id);
        return retournerToutEnseignant();
    }

    public EnseignantName getNameById(Long id) {
        EnseignantName enseignantName = new EnseignantName();
        Enseignant enseignant = enseignantDAO.findById(id).get();
        String fullName = enseignant.getPrenom()+" "+enseignant.getNom();
        enseignantName.setFullName(fullName);
        return enseignantName;
    }
}
