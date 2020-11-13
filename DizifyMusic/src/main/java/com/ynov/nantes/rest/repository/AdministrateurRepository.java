package com.ynov.nantes.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ynov.nantes.rest.entity.Administrateur;

import java.util.List;
import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    /**
     * Recherche un administrateur par son email
     *
     * @param email
     * @return un admin
     */
    @Query("SELECT a FROM  Administrateur a WHERE a.email LIKE :email")
    public List<Administrateur> findAdminByEmail(@Param("email") String email);
}
