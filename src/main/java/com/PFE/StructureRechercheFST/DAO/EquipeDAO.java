package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface EquipeDAO extends JpaRepository<Equipe,Long> {

    Equipe findByNomEquipe(String nomEquipe);

}
