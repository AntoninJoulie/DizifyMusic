package com.ynov.nantes.rest.entity;

import javax.persistence.*;

/**
 * Entité Administrateur
 *
 * @author Joulie Antonin & Cambert Killian
 */
@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admin_id;

    private String email;

    public Integer getAdminId() {
        return admin_id;
    }

    public void setAdminId(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
