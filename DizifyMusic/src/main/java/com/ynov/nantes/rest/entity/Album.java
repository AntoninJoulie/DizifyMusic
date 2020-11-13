package com.ynov.nantes.rest.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entité Album
 *
 * @author Joulie Antonin & Cambert Killian
 */
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer album_id;

    private String album_nom;

    private Date date;

    @ManyToOne
    @JoinColumn(name="artiste_id")
    private Artiste artiste;

    public Integer getAlbumId() {
        return album_id;
    }

    public void setAlbumId(Integer album_id) {
        this.album_id = album_id;
    }

    public String getAlbumNom() {
        return album_nom;
    }

    public void setAlbumNom(String album_nom) {
        this.album_nom = album_nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }
}
