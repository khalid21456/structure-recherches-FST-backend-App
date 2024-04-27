package com.PFE.StructureRechercheFST.RestAPIs.Enseignant;


import com.PFE.StructureRechercheFST.Services.Enseignant.EnseignantService;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Enseignant")
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @PostMapping("/publierEns")
    public void Publier(@RequestBody Publication publication) {
        enseignantService.Publier(publication);
    }

}
