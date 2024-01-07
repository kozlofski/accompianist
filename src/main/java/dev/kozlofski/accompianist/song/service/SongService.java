package dev.kozlofski.accompianist.song.service;

import dev.kozlofski.accompianist.AccompianistConfiguration;
import dev.kozlofski.accompianist.song.domain.model.Song;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    public SongService(AccompianistConfiguration accompianistConfiguration) {
    }

    public List<Song> getSongs() {
        return Arrays.asList(new Song("Name_1", 1), new Song("Name_2", 2));
    }

//    public String test(float value) {
//        return String.format("Hello %s %s", accompianistConfiguration.getName(), value+1.3);
//    }

    public Song getSong(int id) {
        return new Song("Get song", id);
    }

    public Song createSong(Song song) {
        return song;
    }

    public Song updateSong(int id, Song song) {
        return song;
    }

    public void deleteSong(int id) {
        System.out.println("Deleted song no " + id);
    }
}

