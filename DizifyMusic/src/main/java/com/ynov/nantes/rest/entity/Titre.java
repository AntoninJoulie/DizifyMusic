package com.ynov.nantes.rest.entity;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "titre")
public class Titre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer titre_id;

    private String titre_nom;

    private String duree;

    @ManyToOne
    @JoinColumn(name="artiste_id")
    private Artiste artiste;

    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    public Integer getTitreId() {
        return titre_id;
    }

    public void setTitreId(Integer titre_id) {
        this.titre_id = titre_id;
    }

    public String getTitreNom() {
        return titre_nom;
    }

    public void setTitreNom(String titre_nom) {
        this.titre_nom = titre_nom;
    }

    public String getTitreDuree() {
        return duree;
    }

    public void setTitreDuree(String duree) {
        this.duree = duree;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
