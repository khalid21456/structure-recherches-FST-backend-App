package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Equipe_Admin;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/Admin/Equipe")
public class EquipeAdminController {

    @Autowired
    private Equipe_Admin equipeAdmin;

    @PostMapping("/AjouterEquipe")
    public void AjouterEquipe(@RequestBody Equipe equipe) {
        equipeAdmin.AjouterEquipe(equipe);
    }

    @GetMapping("/getAll")
    public List<Equipe> getEquipes() {
        return equipeAdmin.getEquipes();
    }

    @PutMapping("/addMembre/{idEquipe}")
    public void AjouterMembre(@RequestBody List<Enseignant> enseignants, @PathVariable Long idEquipe) {
        equipeAdmin.AjouterMembre(enseignants,idEquipe);
    }

    @GetMapping("/getById/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeAdmin.getEquipeById(id);
    }

}
