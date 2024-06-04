package com.PFE.StructureRechercheFST.Services.Admin;

import com.PFE.StructureRechercheFST.DAO.EquipeDAO;
import com.PFE.StructureRechercheFST.DAO.LaboratoireDAO;
import com.PFE.StructureRechercheFST.models.DTO.StructureLabel;
import com.PFE.StructureRechercheFST.models.Equipe;
import com.PFE.StructureRechercheFST.models.Laboratoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class Structures {

    @Autowired
    private EquipeDAO equipeDAO;

    @Autowired
    private Equipe_Admin equipeAdmin;

    @Autowired
    private Laboratoire_Admin laboratoireAdmin;

    @Autowired
    private LaboratoireDAO laboratoireDAO;

    public List<StructureLabel> getStructuresNames() {
        List<StructureLabel> names = new ArrayList<StructureLabel>();
        List<Equipe> equipes = equipeAdmin.getEquipes();
        List<Laboratoire> laboratoires = laboratoireAdmin.retournerTousLabos();
        Iterator<Laboratoire> iteratorLabo = laboratoires.iterator();
        Iterator<Equipe> iteratorEquipe = equipes.iterator();
        while(iteratorEquipe.hasNext()) {
            Equipe temp = (Equipe) iteratorEquipe.next();
            StructureLabel str = new StructureLabel(Math.toIntExact(temp.getId()), temp.getNomEquipe());
            names.add(str);
        }
        while(iteratorLabo.hasNext()) {
            Laboratoire temp = (Laboratoire) iteratorLabo.next();
            StructureLabel str = new StructureLabel(Math.toIntExact(temp.getId()), temp.getNomLaboratoire());
            names.add(str);
        }
        return names;
    }


}
