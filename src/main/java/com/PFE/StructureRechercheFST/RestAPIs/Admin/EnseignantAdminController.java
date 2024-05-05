package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Enseignant_admin;
import com.PFE.StructureRechercheFST.models.DTO.EnseignantName;
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

    @PutMapping("/ModifierEnseignant/{id}")
    public void modifierEnseignant(@RequestBody Enseignant enseignant,@PathVariable Long id) {

    }

    @GetMapping("/countEnseignants")
    public int countEnseignants() {
        return enseignant_admin.countEnseignants();
    }

    @DeleteMapping("/deleteEns/{id}")
    public void supprimerEnseignant(@PathVariable Long id) {
        enseignant_admin.supprimerEnseignant(id);
    }

    @GetMapping("/getNameById/{id}")
    public EnseignantName getNameById(@PathVariable Long id) {
        return enseignant_admin.getNameById(id);
    }
}
