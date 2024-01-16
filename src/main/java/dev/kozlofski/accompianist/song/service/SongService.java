package dev.kozlofski.accompianist.song.service;

import dev.kozlofski.accompianist.AccompianistConfiguration;
import dev.kozlofski.accompianist.song.domain.model.Song;
import dev.kozlofski.accompianist.song.domain.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Transactional(readOnly = true)
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Song getSong(int id) {
        return songRepository.getById(id); // #fixme deprecated
    }

    @Transactional
    public Song createSong(Song songRequest) {
        Song song = new Song();
        song.setName(songRequest.getName());
        song.setComposer(songRequest.getComposer());

        return songRepository.save(song);
    }

    @Transactional
    public Song updateSong(int id, Song songRequest) {
        Song song = songRepository.getById(id);

        song.setComposer(songRequest.getComposer());

        return songRepository.save(song);
    }

    @Transactional
    public void deleteSong(int id) {
        songRepository.deleteById(id);
    }
}

