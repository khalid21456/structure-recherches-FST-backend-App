package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Recherche_admin;
import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/Admin/Recherche")
public class RechercheAdminController {

    @Autowired
    private Recherche_admin rechercheAdmin;

    @GetMapping("/getAll")
    public List<Recherche> retournerRecherches() {
        return rechercheAdmin.retournerRecherches();
    }

    @GetMapping("/getTitles")
    public List<String> retournerTitre() {
        return rechercheAdmin.retournerTitres();
    }

    @GetMapping("/countRecherches")
    public int countRecherches() {
        return rechercheAdmin.countRecherches();
    }

}
