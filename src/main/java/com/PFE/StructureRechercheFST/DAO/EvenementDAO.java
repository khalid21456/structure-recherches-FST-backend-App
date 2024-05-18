package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementDAO extends JpaRepository<Evenement, Long> {
}
