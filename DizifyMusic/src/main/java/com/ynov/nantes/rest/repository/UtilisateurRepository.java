package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    /**
     * Recherche un utilisateur selon son email
     *
     * @param email
     * @return utilisateur
     */
    @Query("SELECT u FROM Utilisateur u WHERE u.email LIKE :email")
    public List<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}
