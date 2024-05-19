package com.PFE.StructureRechercheFST.DAO;


import com.PFE.StructureRechercheFST.models.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantDAO extends JpaRepository<Doctorant,Long> {
    public Doctorant findDoctorantByEmailAndPassword(String email, String password);
}
