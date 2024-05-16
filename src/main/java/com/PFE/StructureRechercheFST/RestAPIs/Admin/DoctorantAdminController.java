package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Doctorant_admin;
import com.PFE.StructureRechercheFST.Services.Admin.Enseignant_admin;
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

    @PostMapping("/AjouterDoctorant/{name}/{these}")
    public List<Doctorant> ajouterDoctorant(@RequestBody Doctorant doctorant,@PathVariable String name,@PathVariable String these) {
        return doctorant_admin.AjouterDoctorant(doctorant,name,these);
    }

    @GetMapping("/countDoctorants")
    public int countDoctorants() {
        return doctorant_admin.countDoctorants();
    }

    @DeleteMapping("/deleteDoc/{id}")
    public List<Doctorant> supprimerDoctorant(@PathVariable Long id) {
        return doctorant_admin.supprimerDoctorant(id);
    }

}
