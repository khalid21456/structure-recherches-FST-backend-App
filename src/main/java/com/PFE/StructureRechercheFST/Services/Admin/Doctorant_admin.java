package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.RechercheDAO;
import com.PFE.StructureRechercheFST.Services.RandomPasswordGenerator;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Doctorant_admin {

    @Autowired
    private DoctorantDAO doctorantDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;

    @Autowired
    private RechercheDAO rechercheDAO;

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
            if(tempDoc.getEncadrant().getLabo() != null) {
                tempDoc.getEncadrant().getLabo().setResponsable(null);
                tempDoc.getEncadrant().getLabo().setMembresLabo(null);
                tempDoc.getEncadrant().getLabo().setThemes(null);
            }
            if(tempDoc.getEncadrant().getEquipe() != null) {
                tempDoc.getEncadrant().getEquipe().setResponsable(null);
                tempDoc.getEncadrant().getEquipe().setMembres(null);
                tempDoc.getEncadrant().getEquipe().setThemes(null);
            }
        }
        return list;
    }

    public List<Doctorant> AjouterDoctorant(Doctorant doctorant,Long id) {

        Enseignant encadrant = enseignantDAO.findById(id).get();
        doctorant.setEncadrant(encadrant);
        doctorant.setDate_inscri(new Date().toString());
        doctorant.setPassword(randomPasswordGenerator.generatePassword(10));
        if(doctorant.getProfile().equals("")) {
            doctorant.setProfile("userUnknown.png");
        }
        doctorantDAO.save(doctorant);
        return retournerTousDoctorants();
    }

    public int countDoctorants() {
        List<Doctorant> doctorants = doctorantDAO.findAll();
        return doctorants.size();
    }

    public List<Doctorant> supprimerDoctorant(Long id) {
        doctorantDAO.deleteById(id);
        return retournerTousDoctorants();
    }

    public List<Doctorant> getDoctorantByEquipe(Long id) {
        List<Doctorant> doctorants = retournerTousDoctorants();
        List<Doctorant> doctorantList = new ArrayList<Doctorant>();
        Iterator<Doctorant> iterator = doctorants.iterator();
        while(iterator.hasNext()) {
            Doctorant doctorant = iterator.next();
            if(doctorant.getEncadrant().getEquipe()!=null) {
                if(doctorant.getEncadrant().getEquipe().getId().equals(id)) {
                    doctorantList.add(doctorant);
                }
            }

        }
        return doctorantList;
    }

    public List<Doctorant> getDoctorantByLabo(Long id) {
        List<Doctorant> doctorants = retournerTousDoctorants();
        List<Doctorant> doctorantList = new ArrayList<Doctorant>();
        Iterator<Doctorant> iterator = doctorants.iterator();
        while(iterator.hasNext()) {
            Doctorant doctorant = iterator.next();
            if(doctorant.getEncadrant().getLabo()!=null) {
                if(doctorant.getEncadrant().getLabo().getId().equals(id)) {
                    doctorantList.add(doctorant);
                }
            }
        }
        return doctorantList;
    }

}
