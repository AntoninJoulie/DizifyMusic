package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    /**
     * Recherche un album selon son nom
     *
     * @param album_nom
     * @return album
     */
    @Query("SELECT a FROM Album a WHERE a.album_nom LIKE :album_nom")
    public List<Album> findAlbumByName(@Param("album_nom") String album_nom);
}
