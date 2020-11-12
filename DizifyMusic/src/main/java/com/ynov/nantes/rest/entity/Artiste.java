package com.ynov.nantes.rest.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entité Artiste
 *
 * @author Joulie Antonin & Cambert Killian
 */
@Entity
@Table(name = "artiste")
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artisteId;

    private String artisteNom;

    @ManyToMany(mappedBy = "favoris")
    private List<Favori> favoris;

    @OneToMany(mappedBy = "artiste")
    private List<Album> albums;

    @OneToMany(mappedBy = "artiste")
    private List<Titre> titres;

    public Integer getArtisteId() {
        return artisteId;
    }

    public void setArtisteId(Integer artisteId) {
        this.artisteId = artisteId;
    }

    public String getArtisteNom() {
        return artisteNom;
    }

    public void setArtisteNom(String artisteNom) {
        this.artisteNom = artisteNom;
    }

    public List<Favori> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Favori> favoris) {
        this.favoris = favoris;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Titre> getTitres() {
        return titres;
    }

    public void setTitres(List<Titre> titres) {
        this.titres = titres;
    }
}
