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
}
