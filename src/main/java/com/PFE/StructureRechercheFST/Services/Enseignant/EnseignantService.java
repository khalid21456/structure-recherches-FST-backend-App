package com.PFE.StructureRechercheFST.Services.Enseignant;

import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.EvenementDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class EnseignantService {



    @Autowired
    private EnseignantDAO enseignantDAO;
    @Autowired
    private EvenementDAO evenementDAO;



//    public List<Publication> getAllPublicationById(Long id){
//        List<Publication> publicationList = publicationDAO.findAllById(Collections.singleton(id));
//        return publicationList;
//    }

    public void organiser(Evenement evenement, Long id){
        Enseignant enseignant = null;
        if(enseignantDAO.findById(id).isPresent()) {
            enseignant = enseignantDAO.findById(id).get();
        }
        evenement.setEnseignant(enseignant);
        evenementDAO.save(evenement);
    }

    public int countAllEnseignant(){
        List<Enseignant> countAllEnseignant = enseignantDAO.findAll();
        return countAllEnseignant.size();
    }
    public List<Evenement> getTheLatestEvents() {
        List<Evenement> events = evenementDAO.findTop3();
        return events;
    }
    public List<Evenement> getLatestEvent(){
        List<Evenement> events = evenementDAO.findAllOrderByEventIdDesc();
        List<Evenement> latestEvents = events.subList(0, Math.min(events.size(), 2));
        latestEvents.forEach(e->{
            e.setEnseignant(null
            );
        });
        return latestEvents;
    }
    public int countEvents() {
        List<Evenement> events = evenementDAO.findAll();
        return events.size();
    }
}

