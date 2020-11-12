package com.ynov.nantes.rest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "favori")
public class Favori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favoriId;

    @ManyToMany
    private Set<Artiste> artistes = new HashSet<>();

    @ManyToMany
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    private Set<Titre> titres = new HashSet<>();

    @OneToOne
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    public Integer getFavoriId() {
        return favoriId;
    }

    public void setFavoriId(Integer favoriId) {
        this.favoriId = favoriId;
    }

    public Set<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(Set<Artiste> artistes) {
        this.artistes = artistes;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
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
