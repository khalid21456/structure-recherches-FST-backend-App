package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationDAO extends JpaRepository<Publication,Long> {

}
