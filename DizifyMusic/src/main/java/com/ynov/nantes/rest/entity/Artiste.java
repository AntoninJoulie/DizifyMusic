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
    private Integer artiste_id;

    private String artiste_nom;

    public Integer getArtisteId() {
        return artiste_id;
    }

    public void setArtisteId(Integer artiste_id) {
        this.artiste_id = artiste_id;
    }

    public String getArtisteNom() {
        return artiste_nom;
    }

    public void setArtisteNom(String artiste_nom) {
        this.artiste_nom = artiste_nom;
    }
}
