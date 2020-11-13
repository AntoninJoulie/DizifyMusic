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
    private Integer albumId;

    private String albumNom;

    private Date date;

    @ManyToOne
    @JoinColumn(name="artisteId")
    private Artiste artiste;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumNom() {
        return albumNom;
    }

    public void setAlbumNom(String albumNom) {
        this.albumNom = albumNom;
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
