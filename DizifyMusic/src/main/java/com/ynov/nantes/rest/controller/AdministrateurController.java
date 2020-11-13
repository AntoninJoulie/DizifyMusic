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
    @GetMapping("/admin/{admin_id}")
    public Administrateur getAdminById(final @PathVariable("admin_id") Integer admin_id) {
        try {
            Optional<Administrateur> administrateur = administrateurRepository.findById(Integer.valueOf(admin_id));
            return administrateur.get();
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/admin/{admin_id}")
    public void deleteAdmin(final @PathVariable("admin_id") Integer admin_id) {
        administrateurRepository.deleteById(admin_id);
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
    @PutMapping("/admin/{admin_id}")
    public Administrateur editAdministrateur(@RequestBody Administrateur administrateur, @PathVariable(value = "admin_id") Integer admin_id) {
        return administrateurRepository.save(administrateur);
    }
}
