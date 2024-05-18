package com.PFE.StructureRechercheFST.Services.Admin;



import com.PFE.StructureRechercheFST.DAO.RechercheDAO;
import com.PFE.StructureRechercheFST.models.DTO.TheseLabel;
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

    public List<TheseLabel> retournerTitres() {
        List<Recherche> recherches = retournerRecherches();
        List<TheseLabel> theseLabels = new ArrayList<TheseLabel>();
        int i = 0;
        if(recherches!=null) {
            Iterator iterator = recherches.iterator();
            Recherche recherche;
            while(iterator.hasNext()) {
                i++;
                recherche = (Recherche) iterator.next();
                TheseLabel theseLabelOne = new TheseLabel();
                theseLabelOne.setValue(i);
                theseLabelOne.setLabel(recherche.getTitre());
                theseLabels.add(theseLabelOne);
            }
        }
        return theseLabels;
    }

    public int countRecherches() {
        return retournerRecherches().size();
    }

}
