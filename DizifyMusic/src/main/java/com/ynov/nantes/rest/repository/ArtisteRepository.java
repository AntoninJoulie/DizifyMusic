package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {
    /**
     * Recherche un artiste selon son nom
     *
     * @param artiste_nom
     * @return artiste
     */
    @Query("SELECT a FROM Artiste a WHERE a.artiste_nom LIKE :artiste_nom")
    public List<Artiste> findArtisteByName(@Param("artiste_nom") String artiste_nom);
}
