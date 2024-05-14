package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.Services.RandomPasswordGenerator;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Doctorant_admin {

    @Autowired
    private DoctorantDAO doctorantDAO;

    @Autowired
    private RandomPasswordGenerator randomPasswordGenerator;

    public List<Doctorant> retournerTousDoctorants() {
        List<Doctorant> list = doctorantDAO.findAll();
        Doctorant tempDoc = null;
        List<Publication> pubs;
        Publication tempPub;
        Iterator<Publication> iteratorPubs;
        Iterator<Doctorant> iterator = list.iterator();
        while(iterator.hasNext()) {
            tempDoc = iterator.next();
            tempDoc.getEncadrant().setPublications(null);
            tempDoc.getEncadrant().setDoctorants(null);
            pubs = tempDoc.getPublications();
            iteratorPubs = pubs.iterator();
            while(iteratorPubs.hasNext()) {
                tempPub = iteratorPubs.next();
                tempPub.setEnseignant(null);
                tempPub.setDoctorant(null);
            }
        }
        return list;
    }

    public List<Doctorant> AjouterDoctorant(Doctorant doctorant) {
        doctorant.setDate_inscri(new Date());
        doctorant.setPassword(randomPasswordGenerator.generatePassword(10));
        if(doctorant.getProfile().isEmpty()) {
            doctorant.setProfile("userUnknown.png");
        }
        doctorantDAO.save(doctorant);
        return doctorantDAO.findAll();
    }

    public int countDoctorants() {
        List<Doctorant> doctorants = doctorantDAO.findAll();
        return doctorants.size();
    }

    public List<Doctorant> supprimerDoctorant(Long id) {
        doctorantDAO.deleteById(id);
        return retournerTousDoctorants();
    }

}
