package com.ynov.nantes.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ynov.nantes.rest.entity.Administrateur;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

    /**
     * Recherche un administrateur par son id
     *
     * @param adminId l'id
     * @return un admin
     */
    @Query("SELECT a FROM  Administrateur a WHERE a.adminId LIKE :adminId")
    public Optional<Administrateur> findById(@Param("adminId") Integer adminId);
}
