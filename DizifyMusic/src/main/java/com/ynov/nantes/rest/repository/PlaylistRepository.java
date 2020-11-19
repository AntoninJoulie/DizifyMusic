package com.ynov.nantes.rest.repository;

import com.ynov.nantes.rest.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    /**
     * Recherche une playlist selon son nom
     *
     * @param playlist_nom
     * @return playlist
     */
    @Query("SELECT p FROM Playlist p WHERE p.playlist_nom LIKE :playlist_nom")
    public List<Playlist> findPlaylistByNom(@Param("playlist_nom") String playlist_nom);
}
