package com.PFE.StructureRechercheFST.Services.Admin;

import com.PFE.StructureRechercheFST.DAO.ThemeDAO;
import com.PFE.StructureRechercheFST.models.Recherche;
import com.PFE.StructureRechercheFST.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Theme_admin {

    @Autowired
    ThemeDAO themeDAO;

    public void AjouterTheme(Theme theme) {
        themeDAO.save(theme);
    }

    public void SupprimerThem(Long id) {
        themeDAO.deleteById(id);
    }

    public List<Theme> retournerTousLesThemes() {
        List<Theme> themeList = themeDAO.findAll();
        Theme tempTheme;
        Iterator<Theme> themeIterator = themeList.iterator();
        Iterator<Recherche> rechercheIterator;
        while(themeIterator.hasNext()) {
            tempTheme = themeIterator.next();
            rechercheIterator = tempTheme.getRecherches().iterator();
            while(rechercheIterator.hasNext()) {
                rechercheIterator.next().setTheme(null);
            }

        }
        return themeList;
    }

}
