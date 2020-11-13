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
     * @param artisteNom
     * @return artiste
     */
    @Query("SELECT a FROM Artiste a WHERE a.artisteNom LIKE :artisteNom")
public List<Artiste> findArtisteByName(@Param("artisteNom") String artisteNom);
}
