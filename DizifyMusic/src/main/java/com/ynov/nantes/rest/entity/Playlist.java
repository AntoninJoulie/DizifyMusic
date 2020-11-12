package com.ynov.nantes.rest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistId;

    private String playlistNom;

    @ManyToMany
    private Set<Titre> titres = new HashSet<>();

    @ManyToOne
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistNom() {
        return playlistNom;
    }

    public void setPlaylistNom(String playlistNom) {
        this.playlistNom = playlistNom;
    }

    public Set<Titre> getTitres() {
        return titres;
    }

    public void setTitres(Set<Titre> titres) {
        this.titres = titres;
    }

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
