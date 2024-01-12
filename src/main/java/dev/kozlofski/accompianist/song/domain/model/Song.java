package dev.kozlofski.accompianist.song.domain.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Song {
    private final String name;
    private final int id; //#fixme change to more sophisticated id? uuid?

    private String composer;
    private Meter meter;
    private Tonality tonality;

    private String imslpLink;
    private String youTubeLink;
    private String melodyLink; //#fixme trnaslation of polish "prymka"

    @Data
    @RequiredArgsConstructor
    private class Meter {
        private final short beats;
        private final short unit;
    }

    boolean sameTonality(Song song) {
        return this.tonality.getKey() == song.tonality.getKey();
    }

    boolean sameTonality(Song song, boolean checkScale) {
        return this.tonality.getKey() == song.tonality.getKey() &&
                this.tonality.getScale() == song.tonality.getScale();
    }

}
