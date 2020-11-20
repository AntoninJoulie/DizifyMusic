package com.ynov.nantes.rest.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entité Utilisateur
 *
 * @author Joulie Antonin & Cambert Killian
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer utilisateur_id;

    private String email;

    private Boolean is_admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favori_id", referencedColumnName = "favori_id")
    private Favori favori;

    public Integer getUtilisateurId() {
        return utilisateur_id;
    }

    public void setUtilisateurId(Integer utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Favori getFavori() {
        return favori;
    }

    public void setFavori(Favori favori) {
        this.favori = favori;
    }
}
