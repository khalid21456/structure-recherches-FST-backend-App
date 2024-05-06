package com.PFE.StructureRechercheFST.RestAPIs.Admin;

import com.PFE.StructureRechercheFST.Services.Admin.Theme_admin;
import com.PFE.StructureRechercheFST.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/Admin/Theme")
@CrossOrigin
public class ThemeAdmineController {

    @Autowired
    Theme_admin themeAdmin;

    @PostMapping("/AjouterTheme")
    public void AjouterTheme(@RequestBody Theme theme) {
        themeAdmin.AjouterTheme(theme);
    }

    @DeleteMapping("/SupprimerTheme/{id}")
    public void SupprimerThem(@PathVariable Long id) {
        themeAdmin.SupprimerThem(id);
    }

    @GetMapping("/retournerTousLesThemes")
    public List<Theme> retournerTousLesThemes() {
        return themeAdmin.retournerTousLesThemes();
    }
}
