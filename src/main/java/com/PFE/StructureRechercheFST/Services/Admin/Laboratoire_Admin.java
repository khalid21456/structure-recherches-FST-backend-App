package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.LaboratoireDAO;
import com.PFE.StructureRechercheFST.models.DTO.EncadrantLabel;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import com.PFE.StructureRechercheFST.models.Laboratoire;
import com.PFE.StructureRechercheFST.models.Theme;
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
                if(labo.getThemes()!=null) {
                    Iterator iterator2 = labo.getThemes().iterator();
                    Theme theme = null;
                    while(iterator2.hasNext()) {
                        theme = (Theme) iterator2.next();
                        theme.setEquipe(null);
                        theme.setLaboratoire(null);
                        theme.setRecherches(null);
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
        if(laboratoire!=null) {
            if(laboratoire.getThemes()!=null) {
                Iterator<Theme> themeIterator = laboratoire.getThemes().iterator();
                Theme theme = null;
                while(themeIterator.hasNext()) {
                    theme = (Theme)themeIterator.next();
                    theme.setEquipe(null);
                    theme.setLaboratoire(null);
                }
            }

        }
        return laboratoire;
    }

    @Transactional
    public void AjouterUnSeulMembre(EncadrantLabel name, Long id) {
        Enseignant membre = enseignantDAO.findById(Long.parseLong(String.valueOf(name.getValue()))).get();
        Laboratoire labo = laboratoireDAO.findById(id).get();
        membre.setLabo(labo);
    }

    public int countLaboratoires() {
        return laboratoireDAO.findAll().size();
    }

    public List<StructureLabel> retournerNoms() {
        List<StructureLabel> names = new ArrayList<StructureLabel>();
        List<Laboratoire> laboratoires = retournerTousLabos();
        Iterator<Laboratoire> iterator = laboratoires.iterator();
        while(iterator.hasNext()) {
            Laboratoire temp = (Laboratoire) iterator.next();
            StructureLabel str = new StructureLabel(Math.toIntExact(temp.getId()), temp.getNomLaboratoire());
            names.add(str);
        }
        return names;
    }
}
