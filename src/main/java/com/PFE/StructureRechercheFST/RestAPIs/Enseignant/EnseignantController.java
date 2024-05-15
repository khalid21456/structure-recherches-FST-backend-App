package com.PFE.StructureRechercheFST.RestAPIs.Enseignant;


import com.PFE.StructureRechercheFST.Services.Enseignant.EnseignantService;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Enseignant")
@SuppressWarnings("unused")
@CrossOrigin
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @PostMapping("/publierEns/{idPublier}")
    public void Publier(@RequestBody Publication publication, @PathVariable Long idPublier) {
        enseignantService.Publier(publication,idPublier);
    }
    @GetMapping("/allPublication")
    public List<Publication> listPublication() {
        List<Publication> allPublications = enseignantService.listPublications();
        allPublications.forEach(p->{
            p.setEnseignant(null);
            p.setDoctorant(null);
        });
        return  allPublications;
    }

}
