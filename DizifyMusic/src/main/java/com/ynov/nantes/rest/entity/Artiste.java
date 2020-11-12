package com.ynov.nantes.rest.entity;

import javax.persistence.*;

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
}
