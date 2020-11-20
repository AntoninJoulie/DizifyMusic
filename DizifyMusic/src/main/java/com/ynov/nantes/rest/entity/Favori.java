package com.ynov.nantes.rest.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "favori")
public class Favori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favori_id;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "artiste_favori",
            joinColumns = @JoinColumn(name = "favori_id", referencedColumnName = "favori_id"),
            inverseJoinColumns = @JoinColumn(name = "artiste_id",
                    referencedColumnName = "artiste_id"))
    private List<Artiste> artistes;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "album_favori",
            joinColumns = @JoinColumn(name = "favori_id", referencedColumnName = "favori_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id",
                    referencedColumnName = "album_id"))
    private List<Album> albums;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "titre_favori",
            joinColumns = @JoinColumn(name = "favori_id", referencedColumnName = "favori_id"),
            inverseJoinColumns = @JoinColumn(name = "titre_id",
                    referencedColumnName = "titre_id"))
    private List<Titre> titres;

    @OneToOne(mappedBy = "favori")
    private Utilisateur utilisateur;

    public Integer getFavoriId() {
        return favori_id;
    }

    public void setFavoriId(Integer favori_id) {
        this.favori_id = favori_id;
    }

    public List<Artiste> getArtistes() {
        return artistes;
    }

    public void setArtistes(List<Artiste> artistes) {
        this.artistes = artistes;
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
