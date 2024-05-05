package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
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

    public void AjouterDoctorant(Doctorant doctorant) {
        doctorant.setDate_inscri(new Date());
        doctorantDAO.save(doctorant);
    }

    public int countDoctorants() {
        List<Doctorant> doctorants = doctorantDAO.findAll();
        return doctorants.size();
    }

}
