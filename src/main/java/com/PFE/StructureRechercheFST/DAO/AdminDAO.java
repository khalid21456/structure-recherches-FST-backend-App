package com.PFE.StructureRechercheFST.DAO;

import com.PFE.StructureRechercheFST.models.Admin;
import com.PFE.StructureRechercheFST.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin,Long> {
    Admin findAdminByEmailAndPassword(String email, String password);
    Admin findAdminByEmail(String email);
}
