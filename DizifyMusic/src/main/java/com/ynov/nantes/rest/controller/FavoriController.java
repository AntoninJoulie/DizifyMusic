package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Favori;
import com.ynov.nantes.rest.repository.FavoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FavoriController {

    private FavoriRepository favoriRepository;

    @Autowired
    public FavoriController(FavoriRepository favoriRepository) {
        this.favoriRepository = favoriRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/favori", method = RequestMethod.GET, params = "favori_id")
    public List<Favori> getFavoriById(@RequestParam(value = "favori_id", defaultValue = "") Integer favori_id) {
        List<Favori> favori = favoriRepository.findFavoriById(favori_id);
        return favori;
    }

    @ResponseBody
    @GetMapping("/favori")
    public List<Favori> getFavoris() {
        return favoriRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/favori/{favori_id}")
    public Favori getFavoriByFavoriId(final @PathVariable("favori_id") Integer favori_id) {
        try {
            Optional<Favori> favori = favoriRepository.findById(Integer.valueOf(favori_id));
            return favori.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/favori")
    public Favori addFavori(@RequestBody Favori favori) {
        Favori addedFavori = favoriRepository.save(favori);
        return addedFavori;
    }

    @ResponseBody
    @PutMapping("/favori/{favori_id}")
    public Favori editFavori(@RequestBody Favori favori, @PathVariable("favori_id") Integer favori_id) {
        Favori updateFavori = favoriRepository.findById(favori_id).get();
        updateFavori.setArtistes(favori.getArtistes());
        updateFavori.setAlbums(favori.getAlbums());
        updateFavori.setTitres(favori.getTitres());
        final Favori updatedFavori = favoriRepository.save(updateFavori);
        return updatedFavori;
    }

    @DeleteMapping("/favori/{favori_id}")
    void deleteFavoriById(final @PathVariable("favori_id") Integer favori_id) {
        favoriRepository.deleteById(favori_id);
    }
}
