package com.PFE.StructureRechercheFST.Services.Admin;



import com.PFE.StructureRechercheFST.DAO.RechercheDAO;
import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
@SuppressWarnings("unused")

public class Recherche_admin {

    @Autowired
    RechercheDAO rechercheDAO;

    public List<Recherche> retournerRecherches() {

        List<Recherche> recherches = rechercheDAO.findAll();

        if(recherches!=null) {
            Recherche recherche;
            Iterator iteratorRech = recherches.iterator();
            while (iteratorRech.hasNext()) {
                recherche = (Recherche) iteratorRech.next();
                recherche.setTheme(null);
            }
        }
        return recherches;
    }

    public List<String> retournerTitres() {
        List<Recherche> recherches = retournerRecherches();
        List<String> listTitres = new ArrayList<String>();
        if(recherches!=null) {
            Iterator iterator = recherches.iterator();
            Recherche recherche;
            while(iterator.hasNext()) {
                recherche = (Recherche) iterator.next();
                listTitres.add(recherche.getTitre());
            }
        }
        return listTitres;
    }

    public int countRecherches() {
        return retournerRecherches().size();
    }

}
