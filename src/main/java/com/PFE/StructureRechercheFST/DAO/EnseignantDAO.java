package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("unused")
public interface EnseignantDAO extends JpaRepository<Enseignant,Long> {

    Enseignant findByNomContaining(String nom);
    Enseignant findEnseignantByEmailAndPassword(String email, String password);
}
