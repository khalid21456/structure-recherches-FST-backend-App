package com.PFE.StructureRechercheFST.RestAPIs;


import com.PFE.StructureRechercheFST.Services.ScopusService;
import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@SuppressWarnings("unused")
@RequestMapping("/scopus")
public class ScopusController {

    @Autowired
    private ScopusService scopusService;


//    public ScopusController(ScopusService scopusService) {
//        this.scopusService = scopusService;
//    }

    @GetMapping("/publications")
    public ScopusResponse getPublications(@RequestParam String author) {
        return scopusService.getPublicationsByAuthor(author);
    }
}