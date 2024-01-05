package dev.kozlofski.accompianist;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {
    private final AccompianistConfiguration accompianistConfiguration;

    public SongService(AccompianistConfiguration accompianistConfiguration) {
        this.accompianistConfiguration = accompianistConfiguration;
    }

    public List<Song> getSongs() {
        return Arrays.asList(new Song("Name_1", 1), new Song("Name_2", 2));
    }

    public String test(String value) {
        return String.format("Hello %s %s", accompianistConfiguration.getName(), value);
    }
}

