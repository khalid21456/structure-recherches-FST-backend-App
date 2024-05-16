package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Recherche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface RechercheDAO extends JpaRepository<Recherche,Long> {
    Recherche findByTitre(String titre);
}
