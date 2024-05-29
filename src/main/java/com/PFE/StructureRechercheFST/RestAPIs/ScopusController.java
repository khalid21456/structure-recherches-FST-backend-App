package com.PFE.StructureRechercheFST.RestAPIs;


import com.PFE.StructureRechercheFST.Services.ScopusService;
import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/scopus")
public class ScopusController {

    @Autowired
    private ScopusService scopusService;

    @GetMapping("/publications")
    @CrossOrigin(origins = "http://localhost:3000")
    public Stream<ScopusResponse.Publication> getPublications(@RequestParam String author) {
        return scopusService.getPublicationsByAuthor(author);
    }

    @GetMapping("/publicationsByAffil")
    @CrossOrigin(origins = "http://localhost:3000")
    public Stream<ScopusResponse.Publication> getPublicationsByAffilAndAuthor(@RequestParam String author, @RequestParam String affil) {
        return scopusService.getPublicationsByAuthorAndAffiliation(author,affil);
    }

    @GetMapping("/publicationsByISSN")
    @CrossOrigin(origins = "http://localhost:3000")
    public Stream<ScopusResponse.Publication> getPublicationsByISSN(@RequestParam String issn) {
        return scopusService.getPublicationsByISSN(issn);
    }

    @GetMapping("/publicationsByAffil2")
    @CrossOrigin(origins = "http://localhost:3000")
    public ScopusResponse getPublicationsByAffilAndAuthor2(@RequestParam String author,@RequestParam String affil) {
        return scopusService.getPublicationsByAuthorAndAffiliation2(author,affil);
    }

//    @PostMapping("/publications/byAuthors")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<ScopusResponse.Publication> getPublicationsByAuthors(@RequestBody List<String> authors) {
//        return scopusService.getPublicationsByAuthors(authors);
//    }
}