package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Laboratoire_Admin;
import com.PFE.StructureRechercheFST.models.DTO.EncadrantLabel;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Laboratoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/Admin/Laboratoire")
public class LaboratoireAdminController {

    @Autowired
    private Laboratoire_Admin laboratoireAdmin;

    @PostMapping("/addLabo/{id}")
    public List<Laboratoire> AjouterLaboratoire(@RequestBody Laboratoire laboratoire,@PathVariable int id) {
        return laboratoireAdmin.AjouterLaboratoire(laboratoire,id);
    }

    @GetMapping("/getLabos")
    public List<Laboratoire> retournerTousLabos() {
        return laboratoireAdmin.retournerTousLabos();
    }


    @GetMapping("/getById/{id}")
    public Laboratoire getEquipeById(@PathVariable Long id) {
        return laboratoireAdmin.getLaboById(id);
    }

    @PostMapping("/addSeulMembre/{id}")
    public Laboratoire AjouterUnSeulMembre(@RequestBody EncadrantLabel name, @PathVariable long id) {
        return laboratoireAdmin.AjouterUnSeulMembre(name,id);
    }

}
