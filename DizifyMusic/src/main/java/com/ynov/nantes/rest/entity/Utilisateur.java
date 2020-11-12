package com.ynov.nantes.rest.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entité Utilisateur
 *
 * @author Joulie Antonin & Cambert Killian
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer utilisateurId;

    private String email;

    @OneToOne(mappedBy = "utilisateur")
    private Favori favori;

    @OneToMany(mappedBy = "utilisateur")
    private List<Playlist> playlists;

    public Integer getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Integer utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Favori getFavori() {
        return favori;
    }

    public void setFavori(Favori favori) {
        this.favori = favori;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
