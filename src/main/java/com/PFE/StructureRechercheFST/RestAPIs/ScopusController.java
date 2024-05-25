package com.PFE.StructureRechercheFST.RestAPIs;


import com.PFE.StructureRechercheFST.Services.ScopusService;
import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/scopus")
public class ScopusController {

    @Autowired
    private ScopusService scopusService;

    @GetMapping("/publications")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ScopusResponse.Publication> getPublications(@RequestParam String author) {
        return scopusService.getPublicationsByAuthor(author);
    }

//    @PostMapping("/publications/byAuthors")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<ScopusResponse.Publication> getPublicationsByAuthors(@RequestBody List<String> authors) {
//        return scopusService.getPublicationsByAuthors(authors);
//    }
}