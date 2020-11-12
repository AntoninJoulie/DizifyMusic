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
    private Integer favoriId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artisteFavori",
            joinColumns = @JoinColumn(name = "artisteId", referencedColumnName = "artisteId"),
            inverseJoinColumns = @JoinColumn(name = "favoriId",
                    referencedColumnName = "favoriId"))
    private List<Artiste> artistes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "albumFavori",
            joinColumns = @JoinColumn(name = "albumId", referencedColumnName = "albumId"),
            inverseJoinColumns = @JoinColumn(name = "favoriId",
                    referencedColumnName = "favoriId"))
    private List<Album> albums;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "titreFavori",
            joinColumns = @JoinColumn(name = "titreId", referencedColumnName = "titreId"),
            inverseJoinColumns = @JoinColumn(name = "favoriId",
                    referencedColumnName = "favoriId"))
    private List<Titre> titres;

    @OneToOne
    @JoinColumn(name = "utilisateurId")
    private Utilisateur utilisateurs;

    public Integer getFavoriId() {
        return favoriId;
    }

    public void setFavoriId(Integer favoriId) {
        this.favoriId = favoriId;
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

    public Utilisateur getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateur utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
