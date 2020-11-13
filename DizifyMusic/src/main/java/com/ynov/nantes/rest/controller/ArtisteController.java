package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Artiste;
import com.ynov.nantes.rest.repository.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtisteController {

    private ArtisteRepository artisteRepository;

    @Autowired
    public ArtisteController(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/artiste", method = RequestMethod.GET, params = "artisteNom")
    public List<Artiste> getArtistesByName(@RequestParam(value = "artisteNom", defaultValue = "") String artisteNom) {
        List<Artiste> artistes = artisteRepository.findArtisteByName(artisteNom);
        return artistes;
    }

    @ResponseBody
    @GetMapping("/artiste")
    public List<Artiste> getArtistes() {
        return artisteRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/artiste/{artiste_id}")
    public Artiste getArtisteById(final @PathVariable("artiste_id") Integer artiste_id) {
        try {
            Optional<Artiste> artiste = artisteRepository.findById(Integer.valueOf(artiste_id));
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
    @PutMapping("/artiste/{artiste_id}")
    public Artiste editArtiste(@RequestBody Artiste artiste, @PathVariable("artiste_id") Integer artiste_id) {
        Artiste updateArtiste = artisteRepository.findById(artiste_id).get();
        updateArtiste.setArtisteNom(artiste.getArtisteNom());
        final Artiste updatedArtiste = artisteRepository.save(updateArtiste);
        return updatedArtiste;
    }

    @DeleteMapping("/artiste/{artiste_id}")
    void deleteArtisteById(final @PathVariable("artiste_id") Integer artiste_id) {
        artisteRepository.deleteById(artiste_id);
    }
}
