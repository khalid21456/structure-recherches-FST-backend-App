package com.PFE.StructureRechercheFST.RestAPIs.Doctorant;

import com.PFE.StructureRechercheFST.Services.Doctorant.DoctorantService;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Doctorant")
@CrossOrigin
public class DoctorantController {
    @Autowired
    private DoctorantService doctorantService;
    @PostMapping("/PublierDoc/{doctorantID}")
    public void publier(@RequestBody Publication publication, @PathVariable Long doctorantID) {
        doctorantService.publier(publication, doctorantID);
    }
}
