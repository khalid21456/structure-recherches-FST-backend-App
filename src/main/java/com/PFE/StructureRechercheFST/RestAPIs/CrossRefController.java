package com.PFE.StructureRechercheFST.RestAPIs;

import com.PFE.StructureRechercheFST.Services.CrossRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/crosRefScopus")
public class CrossRefController {

    @Autowired
    private CrossRefService crossRefService;

    @GetMapping("/publications")
    public List<Map<String, Object>> getPublications(@RequestParam String author) {
        return crossRefService.getPublicationsByAuthor(author);
    }
}
