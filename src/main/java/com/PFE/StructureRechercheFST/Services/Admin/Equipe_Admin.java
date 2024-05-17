package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.EquipeDAO;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service @SuppressWarnings("unused")
public class Equipe_Admin {

    @Autowired
    private EquipeDAO equipeDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;

    public void AjouterEquipe(Equipe equipe) {
        equipeDAO.save(equipe);
    }

    public List<Equipe> getEquipes() {
        List<Equipe> list = equipeDAO.findAll();
        Iterator iterator = list.iterator();
        Equipe temp = null;
        while(iterator.hasNext()) {
            temp = (Equipe) iterator.next();
            temp.getResponsable().setPublications(null);
            temp.getResponsable().setDoctorants(null);
            temp.getResponsable().setEquipe(null);
            Iterator iterator1 = temp.getMembres().iterator();
            Enseignant enseignant = null;
            while(iterator1.hasNext()) {
                enseignant = (Enseignant) iterator1.next();
                enseignant.setPublications(null);
                enseignant.setDoctorants(null);
            }
        }
        return list;
    }

    @Transactional
    public void AjouterMembre(List<Enseignant> enseignants, Long idEquipe) {
        Equipe equipe = equipeDAO.findById(idEquipe).get();
        Iterator iterator = enseignants.iterator();
        Enseignant enseignant;
        while(iterator.hasNext()) {
            enseignant = (Enseignant) iterator.next();
            enseignant.setEquipe(equipe);
        }
        Iterator iterator2 = enseignants.iterator();
        while(iterator2.hasNext()) {
            enseignantDAO.save((Enseignant)iterator2.next());
        }
    }

    public Equipe getEquipeById(Long id) {
        List<Equipe> equipes = getEquipes();
        Iterator iterator = equipes.iterator();
        Equipe equipe = null;
        while(iterator.hasNext()) {
            equipe = (Equipe)iterator.next();
            if(equipe.getId().equals(id)) {
                break;
            }else {
                equipe = null;
            }
        }
        return equipe;
    }

}
