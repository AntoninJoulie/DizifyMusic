package com.ynov.nantes.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.nantes.rest.entity.Administrateur;
import com.ynov.nantes.rest.repository.AdministrateurRepository;

@RestController
public class AdministrateurController {

    private AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurController(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @ResponseBody
    @GetMapping("/admin/{id}")
    public Administrateur getAdminById(final @PathVariable("id") Integer adminId) {
        try {
            Optional<Administrateur> administrateur = administrateurRepository.findById(Integer.valueOf(adminId));
            return administrateur.get();
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(final @PathVariable("id") Integer adminId) {
        administrateurRepository.deleteById(adminId);
    }

    @GetMapping("/admin")
    public List<Administrateur> getAdministrateurs() {
        return administrateurRepository.findAll();
    }

    @PostMapping("/admin")
    public Administrateur addAdmin(@RequestBody Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @ResponseBody
    @PutMapping("/admin/{id}")
    public Administrateur editAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }
}
