package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.LaboratoireDAO;
import com.PFE.StructureRechercheFST.models.DTO.EncadrantLabel;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import com.PFE.StructureRechercheFST.models.Laboratoire;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Laboratoire_Admin {

    @Autowired
    private LaboratoireDAO laboratoireDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;

    @Autowired
    private Enseignant_admin enseignantAdmin;

    public List<Laboratoire> retournerTousLabos() {
        List<Laboratoire> list = laboratoireDAO.findAll();
        if(list!=null) {
            Iterator iterator = list.iterator();
            Laboratoire labo;
            while(iterator.hasNext()) {
                labo = (Laboratoire) iterator.next();
                labo.getResponsable().setDoctorants(null);
                labo.getResponsable().setLabo(null);
                labo.getResponsable().setEquipe(null);
                labo.getResponsable().setPublications(null);
                if(labo.getMembresLabo()!=null) {
                    List<Enseignant> membres = labo.getMembresLabo();
                    Iterator iterator1 = membres.iterator();
                    Enseignant membre;
                    while(iterator1.hasNext()) {
                        membre = (Enseignant)iterator1.next();
                        membre.setLabo(null);
                        membre.setDoctorants(null);
                        membre.setPublications(null);
                        membre.setEquipe(null);
                    }
                }
            }
        }
        return list;
    }

    public List<Laboratoire> AjouterLaboratoire(Laboratoire laboratoire,int id) {
        Enseignant enseignant =  enseignantDAO.findById(Long.parseLong(String.valueOf(id))).get();
        laboratoire.setResponsable(enseignant);
        laboratoireDAO.save(laboratoire);
        return retournerTousLabos();
    }

    public Laboratoire getLaboById(Long id) {
        List<Laboratoire> labos = retournerTousLabos();
        Iterator iterator = labos.iterator();
        Laboratoire laboratoire = null;
        while(iterator.hasNext()) {
            laboratoire = (Laboratoire)iterator.next();
            if(laboratoire.getId().equals(id)) {
                break;
            }else {
                laboratoire = null;
            }
        }
        return laboratoire;
    }

    @Transactional
//    public List<Enseignant> AjouterUnSeulMembre(EncadrantLabel name, Long id) {
//
//        Enseignant membre = enseignantDAO.findById(Long.parseLong(String.valueOf(name.getValue()))).get();
//        Laboratoire laboratoire = laboratoireDAO.findById(id).get();
//        List<Enseignant> enseignants = enseignantAdmin.retournerToutEnseignant();
//        List<Enseignant> enseignantListByLabo = new ArrayList<Enseignant>();
//        membre.setLabo(laboratoire);
////        List<Laboratoire> laboratoires = retournerTousLabos();
//        Iterator<Enseignant> enseignantIterator = enseignants.iterator();
//        while(enseignantIterator.hasNext()) {
//            Enseignant temp = (Enseignant) enseignantIterator.next();
//            if(temp.getLabo() != null && temp.getLabo().getId() == id ) {
//                enseignantListByLabo.add(temp);
//            }
//        }
//        return enseignantListByLabo;
//    }

    public void AjouterUnSeulMembre(EncadrantLabel name, Long id) {
        Enseignant membre = enseignantDAO.findById(Long.parseLong(String.valueOf(name.getValue()))).get();
        Laboratoire labo = laboratoireDAO.findById(id).get();
        membre.setLabo(labo);
    }

    public int countLaboratoires() {
        return laboratoireDAO.findAll().size();
    }


}
