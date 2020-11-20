package com.ynov.nantes.rest.entity;



import java.util.List;
import java.util.Set;


import javax.persistence.*;

@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlist_id;

    private String playlist_nom;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "titre_playlist",
            joinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "titre_id", referencedColumnName = "titre_id"))
    private List<Titre> titres;

    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateur;

    public Integer getPlaylistId() {
        return playlist_id;
    }

    public void setPlaylistId(Integer playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylistNom() {
        return playlist_nom;
    }

    public void setPlaylistNom(String playlist_nom) {
        this.playlist_nom = playlist_nom;
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
