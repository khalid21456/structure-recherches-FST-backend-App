package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnseignantDAO extends JpaRepository<Enseignant,Long> {

//    Enseignant findById(Long id);

}
