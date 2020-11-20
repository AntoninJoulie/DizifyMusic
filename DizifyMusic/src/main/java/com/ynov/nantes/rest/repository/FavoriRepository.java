package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriRepository extends JpaRepository<Favori, Integer> {
    /**
     * Recherche un favori selon son id
     *
     * @param favori_id
     * @return favori
     */
    @Query("SELECT f.favori_id FROM Favori f ORDER BY f.favori_id")
    public List<Favori> findFavoriById(@Param("favori_id") Integer favori_id);
}
