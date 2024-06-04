package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Structures;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@SuppressWarnings("unused")
@RequestMapping("Admin/Structures")
public class StructuresContoller {

    @Autowired
    private Structures structures;


    @GetMapping("/getNames")
    public List<StructureLabel> getNames() {
        return structures.getStructuresNames();
    }
}
