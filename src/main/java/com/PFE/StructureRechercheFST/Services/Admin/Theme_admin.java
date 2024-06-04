package com.PFE.StructureRechercheFST.Services.Admin;

import com.PFE.StructureRechercheFST.DAO.EquipeDAO;
import com.PFE.StructureRechercheFST.DAO.LaboratoireDAO;
import com.PFE.StructureRechercheFST.DAO.ThemeDAO;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
import com.PFE.StructureRechercheFST.models.Equipe;
import com.PFE.StructureRechercheFST.models.Laboratoire;
import com.PFE.StructureRechercheFST.models.Recherche;
import com.PFE.StructureRechercheFST.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Theme_admin {

    @Autowired
    ThemeDAO themeDAO;

    @Autowired
    EquipeDAO equipeDAO;

    @Autowired
    LaboratoireDAO laboratoireDAO;

    public List<Theme> AjouterTheme(Theme theme, String structure) {
        if(theme.getImagePath().isEmpty()) {
            theme.setImagePath("noneTheme.png");
        }
        Equipe equipe = equipeDAO.findByNomEquipe(structure);
        Laboratoire laboratoire = laboratoireDAO.findByNomLaboratoire(structure);
        if(equipe != null) {
            theme.setEquipe(equipe);
        }else if(laboratoire != null) {
            theme.setLaboratoire(laboratoire);
        }
        themeDAO.save(theme);
        return retournerTousLesThemes();
    }

    public List<Theme> SupprimerTheme(Long id) {
        themeDAO.deleteById(id);
        return retournerTousLesThemes();
    }

    public List<Theme> retournerTousLesThemes() {
        List<Theme> themeList = themeDAO.findAll();
        Theme tempTheme;
        Iterator<Theme> themeIterator = themeList.iterator();
        Recherche recherche;
        Iterator<Recherche> rechercheIterator;
        while(themeIterator.hasNext()) {
            tempTheme = themeIterator.next();
            tempTheme.setLaboratoire(null);
            tempTheme.setEquipe(null);
            if(tempTheme.getRecherches()!=null) {
                rechercheIterator = tempTheme.getRecherches().iterator();
                while(rechercheIterator.hasNext()) {
                    recherche = rechercheIterator.next();
                    recherche.setTheme(null);

                }
            }
        }
        return themeList;
    }

//    public List<Theme> getThemesByEquipe(Long id) {
//        List<Theme> themes = new ArrayList<Theme>();
//        List<Equipe> equipes = retournerTousLesThemes()
//        return themes;
//    }
//
//    public List<Theme> getThemesByLabo(Long id) {
//        List<Theme> themes = new ArrayList<Theme>();
//        return themes;
//    }


}
