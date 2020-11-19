package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Album;
import com.ynov.nantes.rest.entity.Artiste;
import com.ynov.nantes.rest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {

    private AlbumRepository albumRepository;

    @Autowired
    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/album", method = RequestMethod.GET, params = "album_nom")
    public List<Album> getAlbumsByName(@RequestParam(value = "album_nom", defaultValue = "") String album_nom) {
        List<Album> albums = albumRepository.findAlbumByName(album_nom);
        return albums;
    }

    @ResponseBody
    @GetMapping("/album")
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/album/{album_id}")
    public Album getAlbumById(final @PathVariable("album_id") Integer album_id) {
        try {
            Optional<Album> album = albumRepository.findById(Integer.valueOf(album_id));
            return album.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/album")
    public Album addAlbum(@RequestBody Album album) {
        Album addedAlbum = albumRepository.save(album);
        return addedAlbum;
    }

    @ResponseBody
    @PutMapping("/album/{album_id}")
    public Album editAlbum(@RequestBody Album album, @PathVariable("album_id") Integer album_id) {
        Album updateAlbum = albumRepository.findById(album_id).get();
        updateAlbum.setAlbumNom(album.getAlbumNom());
        updateAlbum.setDate(album.getDate());
        updateAlbum.setArtiste(album.getArtiste());
        final Album updatedAlbum = albumRepository.save(updateAlbum);
        return updatedAlbum;
    }

    @DeleteMapping("/album/{album_id}")
    void deleteAlbumById(final @PathVariable("album_id") Integer album_id) {
        albumRepository.deleteById(album_id);
    }

}
