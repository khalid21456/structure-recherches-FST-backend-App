package com.PFE.StructureRechercheFST.RestAPIs.Login;

import com.PFE.StructureRechercheFST.Services.Login.LoginService;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/ConnectDoc/{email}/{password}")
    public ResponseEntity<Doctorant> connectDoctorant(@PathVariable String email, @PathVariable String password){
        Doctorant doctorant = loginService.connectDoctorant(email, password);
        return ResponseEntity.ok(doctorant);
    }
    @GetMapping("/ConnectEns/{email}/{password}")
    public ResponseEntity<Enseignant> connectEnseignant(@PathVariable String email, @PathVariable String password){
        Enseignant enseignant = loginService.connectEnseignant(email, password);
        return ResponseEntity.ok(enseignant);
    }
    //Connect Admin

}
