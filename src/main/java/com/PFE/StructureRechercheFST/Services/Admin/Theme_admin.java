package com.PFE.StructureRechercheFST.Services.Admin;

import com.PFE.StructureRechercheFST.DAO.ThemeDAO;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
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

    public List<Theme> AjouterTheme(Theme theme) {
        if(theme.getImagePath().isEmpty()) {
            theme.setImagePath("noneTheme.png");
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



}
