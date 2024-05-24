package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementDAO extends JpaRepository<Evenement, Long> {
    @Query(value = "SELECT e FROM Evenement e ORDER BY e.id ASC")
    List<Evenement> findTop3();
    @Query("SELECT e FROM Evenement e ORDER BY e.id DESC")
    List<Evenement> findAllOrderByEventIdDesc();
}
