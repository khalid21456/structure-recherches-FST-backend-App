package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Enseignant_admin;
import com.PFE.StructureRechercheFST.models.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin/Enseignant")
@SuppressWarnings("unused")
@CrossOrigin
public class EnseignantAdminController {

    @Autowired
    private Enseignant_admin enseignant_admin;

    @PostMapping("/AjouterEnseignant")
    public void AjouterEnseignant(@RequestBody Enseignant enseignant) {
        enseignant_admin.AjouterEnseignant(enseignant);
    }

    @GetMapping("/getAll")
    public List<Enseignant> retournerToutEnseignant() {
        return enseignant_admin.retournerToutEnseignant();
    }

}
