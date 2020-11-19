package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitreRepository extends JpaRepository<Titre, Integer> {
    /**
     * Recherche un titre selon son nom
     *
     * @param titre_nom
     * @return titre
     */
    @Query("SELECT t FROM Titre t WHERE t.titre_nom LIKE :titre_nom")
    public List<Titre> findTitreByName(@Param("titre_nom") String titre_nom);
}
