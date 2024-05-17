package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EquipeDAO;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service @SuppressWarnings("unused")
public class Equipe_Admin {

    @Autowired
    private EquipeDAO equipeDAO;


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

}
