package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Doctorant_admin;
import com.PFE.StructureRechercheFST.models.Doctorant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Admin/Doctorant")
@SuppressWarnings("unused")
public class DoctorantAdminController {

    @Autowired
    private Doctorant_admin doctorant_admin;

    @GetMapping("/getAll")
    public List<Doctorant> retournerTousDoctorants() {
        return doctorant_admin.retournerTousDoctorants();
    }

    @PostMapping("/AjouterDoctorant/{id}")
    public List<Doctorant> ajouterDoctorant(@RequestBody Doctorant doctorant,@PathVariable Long id) {
        return doctorant_admin.AjouterDoctorant(doctorant,id);
    }

    @GetMapping("/countDoctorants")
    public int countDoctorants() {
        return doctorant_admin.countDoctorants();
    }

    @DeleteMapping("/deleteDoc/{id}")
    public List<Doctorant> supprimerDoctorant(@PathVariable Long id) {
        return doctorant_admin.supprimerDoctorant(id);
    }

    @GetMapping("/getByEquipe/{id}")
    public List<Doctorant> getDoctorantByEquipe(@PathVariable Long id) {
        return doctorant_admin.getDoctorantByEquipe(id);
    }

    @GetMapping("/getByLabo/{id}")
    public List<Doctorant> getDoctorantByLabo(@PathVariable Long id) {
        return doctorant_admin.getDoctorantByLabo(id);
    }

}
