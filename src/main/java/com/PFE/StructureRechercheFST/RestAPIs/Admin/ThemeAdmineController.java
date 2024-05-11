package com.PFE.StructureRechercheFST.RestAPIs.Admin;

import com.PFE.StructureRechercheFST.RestAPIs.ImageController;
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

    @Autowired
    ImageController imageController;

    @PostMapping("/AjouterTheme")
    public List<Theme> AjouterTheme(@RequestBody Theme theme) {
        return themeAdmin.AjouterTheme(theme);
    }

    @DeleteMapping("/SupprimerTheme/{id}")
    public List<Theme> SupprimerTheme(@PathVariable Long id) {
        return themeAdmin.SupprimerTheme(id);
    }

    @GetMapping("/retournerTousLesThemes")
    public List<Theme> retournerTousLesThemes() {
        return themeAdmin.retournerTousLesThemes();
    }
}
