package com.PFE.StructureRechercheFST.DAO;


import com.PFE.StructureRechercheFST.models.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface LaboratoireDAO extends JpaRepository<Laboratoire,Long> {
    Laboratoire findByNomLaboratoire(String nomLaboratoire);
}
