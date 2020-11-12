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
    private Integer titreId;

    private String titreNom;

    private Time titreDuree;

    @ManyToOne
    @JoinColumn(name="artisteId")
    private Artiste artistes;

    @ManyToOne
    @JoinColumn(name="AlbumId")
    private Album albums;

    @ManyToMany(mappedBy = "titres")
    private List<Favori> favoris;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "playlistTitre",
            joinColumns = @JoinColumn(name = "playlistId", referencedColumnName = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "TitreId",
                    referencedColumnName = "TitreId"))
    private List<Playlist> playlists;

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

    public List<Favori> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Favori> favoris) {
        this.favoris = favoris;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
