package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Artiste;
import com.ynov.nantes.rest.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ArtisteController {

    private ArtisteRepository artisteRepository;

    @Autowired
    public ArtisteController(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/artiste", method = RequestMethod.GET, params = "artisteNom")
    public List<Artiste> getArtistesByName(@RequestParam(value = "artisteNom", defaultValue = "") String artisteNom) {
        List<Artiste> artistes = artisteRepository.findByName(artisteNom);
        return artistes;
    }

    @ResponseBody
    @GetMapping("/artiste")
    public List<Artiste> getArtistes() {
        return artisteRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/artiste/{artisteId}")
    public Artiste getArtisteById(final @PathVariable("artisteId") Integer artisteId) {
        try {
            Optional<Artiste> artiste = artisteRepository.findById(Integer.valueOf(artisteId));
            return artiste.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/artiste")
    public Artiste addArtiste(@RequestBody Artiste artiste) {
        Artiste addedArtiste = artisteRepository.save(artiste);
        return addedArtiste;
    }

    @ResponseBody
    @PutMapping("/artiste/{artisteId}")
    public Artiste editArtiste(@RequestBody Artiste artiste) {
        Artiste updatedArtiste = artisteRepository.save(artiste);
        return updatedArtiste;
    }

    @DeleteMapping("artiste/{artisteId}")
    void deleteArtisteById(final @PathVariable("artisteId") Integer artisteId) {
        artisteRepository.deleteById(artisteId);
    }
}
