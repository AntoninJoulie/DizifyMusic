package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Album;
import com.ynov.nantes.rest.entity.Titre;
import com.ynov.nantes.rest.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TitreController {

    private TitreRepository titreRepository;

    @Autowired
    public TitreController(TitreRepository titreRepository) {
        this.titreRepository = titreRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/titre", method = RequestMethod.GET, params = "titre_nom")
    public List<Titre> getTitresByName(@RequestParam(value = "titre_nom", defaultValue = "") String titre_nom) {
        List<Titre> titres = titreRepository.findTitreByName(titre_nom);
        return titres;
    }

    @ResponseBody
    @GetMapping("/titre")
    public List<Titre> getTitres() {
        return titreRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/titre/{titre_id}")
    public Titre getTitreById(final @PathVariable("titre_id") Integer titre_id) {
        try {
            Optional<Titre> titre = titreRepository.findById(Integer.valueOf(titre_id));
            return titre.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/titre")
    public Titre addTitre(@RequestBody Titre titre) {
        Titre addedTitre = titreRepository.save(titre);
        return addedTitre;
    }

    @ResponseBody
    @PutMapping("/titre/{titre_id}")
    public Titre editTitre(@RequestBody Titre titre, @PathVariable("titre_id") Integer titre_id) {
        Titre updateTitre = titreRepository.findById(titre_id).get();
        updateTitre.setTitreNom(titre.getTitreNom());
        updateTitre.setTitreDuree(titre.getTitreDuree());
        updateTitre.setAlbum(titre.getAlbum());
        updateTitre.setArtiste(titre.getArtiste());
        final Titre updatedTitre = titreRepository.save(updateTitre);
        return updatedTitre;
    }

    @DeleteMapping("/titre/{titre_id}")
    void deleteTitreById(final @PathVariable("titre_id") Integer titre_id) {
        titreRepository.deleteById(titre_id);
    }

}
