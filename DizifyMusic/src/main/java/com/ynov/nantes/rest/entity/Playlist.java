package com.ynov.nantes.rest.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistId;

    private String playlistNom;

    @ManyToMany
    private List<Titre> titres;

    @ManyToOne
    @JoinColumn(name="utilisateurId")
    private Utilisateur utilisateur;

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

    public List<Titre> getTitres() {
        return titres;
    }

    public void setTitres(List<Titre> titres) {
        this.titres = titres;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
