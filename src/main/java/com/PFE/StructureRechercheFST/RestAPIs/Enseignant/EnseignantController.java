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

//    @PostMapping("/publierEns/{idPublier}")
//    public void Publier(@RequestBody Publication publication, @PathVariable Long idPublier) {
//        enseignantService.Publier(publication,idPublier);
//    }
//    @GetMapping("/allPublication")
//    public  List<Publication> listPublications() {
//        List<Publication> allPublications = enseignantService.allPublications();
//        allPublications.forEach(p->{
//            p.setEnseignant(null);
//            p.setDoctorant(null);
//        });
//        return allPublications;
//    }
//    @GetMapping("/publicationsList/{id}")
//    public List<Publication> allPublicationById(@PathVariable Long id){
//        List<Publication> publicationList = enseignantService.getAllPublicationById(id);
//        publicationList.forEach(p->{
//            p.setEnseignant(null);
//            p.setDoctorant(null);
//        });
//        return publicationList;
//    }
//       @GetMapping("/publicationsByEnseignant/{id}")
//       public List<Publication> allPublicationsByEnseignant(@PathVariable Long id) {
//              List<Publication> publicationList = enseignantService.getAllPublicationsByEnseignantId(id);
//                    publicationList.forEach(p -> {
//                            p.setEnseignant(null);
//                            p.setDoctorant(null);
//          });
//                     return publicationList;
//      }
      @PostMapping("/organiser")
      public void organiserEvenement(@RequestBody Evenement evenement) {
        enseignantService.organiser(evenement);
      }
//      @GetMapping("/countPublication/{id}")
//      public int countPublicationByEnseignant(@PathVariable Long id){
//        return enseignantService.coutPublicationByEnseignantId(id);
//     }
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
