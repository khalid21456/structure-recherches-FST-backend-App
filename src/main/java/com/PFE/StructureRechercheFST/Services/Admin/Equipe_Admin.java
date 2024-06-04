package com.PFE.StructureRechercheFST.Services.Admin;


import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.EquipeDAO;
import com.PFE.StructureRechercheFST.models.DTO.EncadrantLabel;
import com.PFE.StructureRechercheFST.models.DTO.EnseignantName;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import com.PFE.StructureRechercheFST.models.Theme;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service @SuppressWarnings("unused")
public class Equipe_Admin {

    @Autowired
    private EquipeDAO equipeDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;

    @Autowired
    private Enseignant_admin enseignant_admin;

    public List<Equipe> AjouterEquipe(Equipe equipe,int id) {

        Enseignant enseignant =  enseignantDAO.findById(Long.parseLong(String.valueOf(id))).get();
        equipe.setResponsable(enseignant);
        equipeDAO.save(equipe);
        return getEquipes();
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
            temp.getResponsable().setLabo(null);
            if(temp.getMembres()!=null) {
                Iterator iterator1 = temp.getMembres().iterator();
                Enseignant enseignant = null;
                while(iterator1.hasNext()) {
                    enseignant = (Enseignant) iterator1.next();
                    enseignant.setPublications(null);
                    enseignant.setDoctorants(null);
                    enseignant.setEquipe(null);
                }
            }
            if(temp.getThemes()!=null) {
                Iterator iterator2 = temp.getThemes().iterator();
                Theme theme = null;
                while(iterator2.hasNext()) {
                    theme = (Theme) iterator2.next();
                    theme.setEquipe(null);
                    theme.setLaboratoire(null);
                    theme.setRecherches(null);
                }
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

    @Transactional
    public void AjouterUnSeulMembre(EncadrantLabel name, Long id) {

        Enseignant membre = enseignantDAO.findById(Long.parseLong(String.valueOf(name.getValue()))).get();
        Equipe equipe = equipeDAO.findById(id).get();
        membre.setEquipe(equipe);
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

    public List<EncadrantLabel> getMembreChoices() {
        List<Enseignant> enseignants =  enseignantDAO.findAll();
        List<EncadrantLabel> choices = new ArrayList<EncadrantLabel>();
        Iterator iterator = enseignants.iterator();
        Enseignant enseignant = null;
        while(iterator.hasNext()) {
            enseignant = (Enseignant) iterator.next();
            if(enseignant.getEquipe()==null) {
                EncadrantLabel encadrantLabel = new EncadrantLabel();
                encadrantLabel.setValue(Math.toIntExact(enseignant.getId()));
                encadrantLabel.setLabel(enseignant.getPrenom()+" "+enseignant.getNom());
                choices.add(encadrantLabel);
            }
        }
        return choices;
    }

    public int countEquipes() {
        return equipeDAO.findAll().size();
    }

    public List<StructureLabel> retournerNoms() {
        List<StructureLabel> names = new ArrayList<StructureLabel>();
        List<Equipe> equipes = getEquipes();
        Iterator<Equipe> iterator = equipes.iterator();
        while(iterator.hasNext()) {
            Equipe temp = (Equipe) iterator.next();
            StructureLabel str = new StructureLabel(Math.toIntExact(temp.getId()), temp.getNomEquipe());
            names.add(str);
        }
        return names;
    }

}
