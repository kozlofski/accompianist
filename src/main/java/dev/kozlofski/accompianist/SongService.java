package dev.kozlofski.accompianist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    public List<Song> getSongs() {
        return Arrays.asList(new Song("Name_1", 1), new Song("Name_2", 2));
    }
}

