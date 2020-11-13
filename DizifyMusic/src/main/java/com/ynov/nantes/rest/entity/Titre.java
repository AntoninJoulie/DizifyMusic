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

    private Time titre_duree;

    @ManyToOne
    @JoinColumn(name="artiste_id")
    private Artiste artistes;

    @ManyToOne
    @JoinColumn(name="album_id")
    private Album albums;

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

    public Time getTitreDuree() {
        return titre_duree;
    }

    public void setTitreDuree(Time titre_duree) {
        this.titre_duree = titre_duree;
    }

    public Artiste getArtistes() {
        return artistes;
    }

    public void setArtistes(Artiste artistes) {
        this.artistes = artistes;
    }

    public Album getAlbums() {
        return albums;
    }

    public void setAlbums(Album albums) {
        this.albums = albums;
    }
}
