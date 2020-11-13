package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Album;
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
    @RequestMapping(value = "/album", method = RequestMethod.GET, params = "albumNom")
    public List<Album> getAlbumsByName(@RequestParam(value = "albumNom", defaultValue = "") String albumNom) {
        List<Album> albums = albumRepository.findAlbumByName(albumNom);
        return albums;
    }

    @ResponseBody
    @GetMapping("/album")
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/album/{albumId}")
    public Album getAlbumById(final @PathVariable("albumId") Integer albumId) {
        try {
            Optional<Album> album = albumRepository.findById(Integer.valueOf(albumId));
            return album.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping
    public Album addAlbum(@RequestBody Album album) {
        Album addedAlbum = albumRepository.save(album);
        return addedAlbum;
    }

    @ResponseBody
    @PutMapping("/album/{albumId}")
    public Album editArtiste(@RequestBody Album album) {
        Album updatedAlbum= albumRepository.save(album);
        return updatedAlbum;
    }

    @DeleteMapping("/album/{albumId}")
    void deleteAlbumById(final @PathVariable("albumId") Integer albumId) {
        albumRepository.deleteById(albumId);
    }

}
