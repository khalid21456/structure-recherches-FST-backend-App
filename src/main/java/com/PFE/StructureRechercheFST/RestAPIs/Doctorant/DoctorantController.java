package com.PFE.StructureRechercheFST.RestAPIs.Doctorant;

import com.PFE.StructureRechercheFST.Services.Doctorant.DoctorantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Doctorant")
@CrossOrigin
@SuppressWarnings("unused")
public class DoctorantController {
    @Autowired
    private DoctorantService doctorantService;

    @GetMapping("/AllDoctorant")
    public int allDoctorant() {
        return doctorantService.getAllDoctorant();
    }
}
