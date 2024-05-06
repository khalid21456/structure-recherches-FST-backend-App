package com.PFE.StructureRechercheFST.RestAPIs.Enseignant;


import com.PFE.StructureRechercheFST.Services.Enseignant.RechercheService;
import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Enseignant/Recherche")
@SuppressWarnings("unused")
public class RechercheEnseignantController {

    @Autowired
    private RechercheService rechercheService;

    @PostMapping("/posterUnRecherche")
    public void posterUnRecherche(@RequestBody Recherche recherche) {
        rechercheService.posterUnRecherche(recherche);
    }

}
