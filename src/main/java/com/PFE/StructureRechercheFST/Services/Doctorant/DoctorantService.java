package com.PFE.StructureRechercheFST.Services.Doctorant;

import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DoctorantService {

    @Autowired
    private DoctorantDAO doctorantDAO;

    public int getAllDoctorant() {
        List<Doctorant> allDoctorant = doctorantDAO.findAll();
        return allDoctorant.size();
    }
}
