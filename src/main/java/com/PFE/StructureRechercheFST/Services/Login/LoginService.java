package com.PFE.StructureRechercheFST.Services.Login;

import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class LoginService {
    @Autowired
   private EnseignantDAO enseignantDAO;
    @Autowired
   private DoctorantDAO doctorantDAO;
//    @Autowired
//   private AdministrateurDAO administrateurDAO;
    public Doctorant connectDoctorant(String email, String password){
       Doctorant doctorant = doctorantDAO.findDoctorantByEmailAndPassword(email, password);
        List<Publication> doctorantPubs = doctorant.getPublications();
        doctorantPubs.forEach(p->{
            p.setEnseignant(null);
            p.setDoctorant(null);
        });
       doctorant.getEncadrant().setDoctorants(null);
       doctorant.setEncadrant(null);
//     doctorant.setPublications(null);
     doctorant.setThese(null);
       return doctorant;
    }
    public Enseignant connectEnseignant(String email, String password) {
        Enseignant enseignant = enseignantDAO.findEnseignantByEmailAndPassword(email, password);
        List<Publication> enseignantPubs = enseignant.getPublications();
        enseignantPubs.forEach(p->{
            p.setEnseignant(null);
            p.setDoctorant(null);
        });
        List<Doctorant> enseignantDocs = enseignant.getDoctorants();
        enseignantDocs.forEach(d->{
            d.setEncadrant(null);
            d.setPublications(null);
            d.setThese(null);
        });
        enseignant.setEquipe(null);
        return enseignant;
    }
}
