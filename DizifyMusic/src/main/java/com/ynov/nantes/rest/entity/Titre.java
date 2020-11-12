package com.ynov.nantes.rest.entity;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titre")
public class Titre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer titreId;

    private String titreNom;

    private Time titreDuree;

    @ManyToOne
    private Set<Artiste> artistes = new HashSet<>();

    @ManyToOne
    private Set<Album> albums = new HashSet<>();

    public Integer getTitreId() {
        return titreId;
    }

    public void setTitreId(Integer titreId) {
        this.titreId = titreId;
    }

    public String getTitreNom() {
        return titreNom;
    }

    public void setTitreNom(String titreNom) {
        this.titreNom = titreNom;
    }

    public Time getTitreDuree() {
        return titreDuree;
    }

    public void setTitreDuree(Time titreDuree) {
        this.titreDuree = titreDuree;
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
}
