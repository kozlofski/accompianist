package dev.kozlofski.accompianist.song.controller;

import dev.kozlofski.accompianist.song.domain.model.Song;
import dev.kozlofski.accompianist.song.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Song getSong(@PathVariable int id) {
        return songService.getSong(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Song updateSong(@PathVariable int id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSong(@PathVariable int id) {
        songService.deleteSong(id);
    }
}
