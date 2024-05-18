package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationDAO extends JpaRepository<Publication,Long> {
    List<Publication> findByEnseignantId(Long enseignantId);
}
