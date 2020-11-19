package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Utilisateur;
import com.ynov.nantes.rest.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/utilisateur", method = RequestMethod.GET, params = "email")
    public List<Utilisateur> getUtilisateursByEmail(@RequestParam(value = "email", defaultValue = "") String email) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findUtilisateurByEmail(email);
        return utilisateurs;
    }

    @ResponseBody
    @GetMapping("/utilisateur")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/utilisateur/{utilisateur_id}")
    public Utilisateur getUtilisateurById(final @PathVariable("utilisateur_id") Integer utilisateur_id) {
        try {
            Optional<Utilisateur> utilisateur = utilisateurRepository.findById(Integer.valueOf(utilisateur_id));
            return utilisateur.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/utilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur addedUtilisateur = utilisateurRepository.save(utilisateur);
        return addedUtilisateur;
    }

    @ResponseBody
    @PutMapping("/utilisateur/{utilisateur_id}")
    public Utilisateur editUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable("utilisateur_id") Integer utilisateur_id) {
        Utilisateur updateUtilisateur = utilisateurRepository.findById(utilisateur_id).get();
        updateUtilisateur.setEmail(utilisateur.getEmail());
        final Utilisateur updatedUtilisateur = utilisateurRepository.save(updateUtilisateur);
        return updatedUtilisateur;
    }

    @DeleteMapping("/utilisateur/{utilisateur_id}")
    void deleteUtilisateurById(final @PathVariable("utilisateur_id") Integer utilisateur_id) {
        utilisateurRepository.deleteById(utilisateur_id);
    }
}
