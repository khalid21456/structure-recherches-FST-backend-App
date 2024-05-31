package com.PFE.StructureRechercheFST.RestAPIs.Enseignant;


import com.PFE.StructureRechercheFST.Services.Enseignant.EnseignantService;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Evenement;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Enseignant")
@SuppressWarnings("unused")
@CrossOrigin
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;



//    @GetMapping("/publicationsList/{id}")
//    public List<Publication> allPublicationById(@PathVariable Long id){
//        List<Publication> publicationList = enseignantService.getAllPublicationById(id);
//        publicationList.forEach(p->{
//            p.setEnseignant(null);
//            p.setDoctorant(null);
//        });
//        return publicationList;
//    }

      @PostMapping("/organiser")
      public void organiserEvenement(@RequestBody Evenement evenement) {
        enseignantService.organiser(evenement);
      }

     @GetMapping("/AllEnseignant")
     public int countAllEnseignant() {
        return enseignantService.countAllEnseignant();
     }
     @GetMapping("/FindTop3Events")
    public List<Evenement> getTheLatestEvents(){
        return enseignantService.getTheLatestEvents();
     }
     @GetMapping("/LatestEvent")
     public List<Evenement> latestEvent() {
        return enseignantService.getLatestEvent();
     }
     @GetMapping("/countEvents")
    public int countEvents() {
        return enseignantService.countEvents();
     }


}
