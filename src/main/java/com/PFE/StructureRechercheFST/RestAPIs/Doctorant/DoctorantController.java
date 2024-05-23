package com.PFE.StructureRechercheFST.RestAPIs.Doctorant;

import com.PFE.StructureRechercheFST.Services.Doctorant.DoctorantService;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Doctorant")
@CrossOrigin
@SuppressWarnings("unused")
public class DoctorantController {
    @Autowired
    private DoctorantService doctorantService;
    @PostMapping("/PublierDoc/{doctorantID}")
    public void publier(@RequestBody Publication publication, @PathVariable Long doctorantID) {
        doctorantService.publier(publication, doctorantID);
    }
    @GetMapping("/publicationsByDoctorant/{id}")
    public List<Publication> allPublicationsByEnseignant(@PathVariable Long id) {
        List<Publication> publicationList = doctorantService.getAllPublicationsByDoctorantId(id);
        publicationList.forEach(p -> {
            p.setEnseignant(null);
            p.setDoctorant(null);
        });
        return publicationList;
    }
    @GetMapping("/AllDoctorant")
    public int allDoctorant() {
        return doctorantService.getAllDoctorant();
    }
}
