package dev.kozlofski.accompianist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    List<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/test")
    String test(@RequestParam String value) {
        return songService.test(value);
    }
}
