package com.ynov.nantes.rest.controller;

import com.ynov.nantes.rest.entity.Playlist;
import com.ynov.nantes.rest.entity.Titre;
import com.ynov.nantes.rest.repository.PlaylistRepository;
import com.ynov.nantes.rest.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class PlaylistController {

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistController(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/playlist", method = RequestMethod.GET, params = "playlist_nom")
    public List<Playlist> getPlaylistByName(@RequestParam(value = "playlist_nom", defaultValue = "") String playslist_nom) {
        List<Playlist> playlists = playlistRepository.findPlaylistByNom(playslist_nom);
        return playlists;
    }

    @ResponseBody
    @GetMapping("/playlist")
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/playlist/{playlist_id}")
    public Playlist getPlaylistById(final @PathVariable("playlist_id") Integer playlist_id) {
        try {
            Optional<Playlist> playlist = playlistRepository.findById(Integer.valueOf(playlist_id));
            return playlist.get();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/playlist")
    public Playlist addPlaylist(@RequestBody Playlist playlist) {
        Playlist addedPlaylist = playlistRepository.save(playlist);
        return addedPlaylist;
    }

    @ResponseBody
    @PutMapping("/playlist/{playlist_id}")
    public Playlist editPlaylist(@RequestBody Playlist playlist, @PathVariable("playlist_id") Integer playlist_id) {
        Playlist updatePlaylist = playlistRepository.findById(playlist_id).get();
        updatePlaylist.setPlaylistNom(playlist.getPlaylistNom());
        updatePlaylist.setTitres(playlist.getTitres());
        final Playlist updatedPlaylist = playlistRepository.save(updatePlaylist);
        return updatedPlaylist;
    }

    @DeleteMapping("/playlist/{playlist_id}")
    void deletePlaylistById(final @PathVariable("playlist_id") Integer playlist_id) {
        playlistRepository.deleteById(playlist_id);
    }
}
