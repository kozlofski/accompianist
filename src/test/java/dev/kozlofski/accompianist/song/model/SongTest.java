package dev.kozlofski.accompianist.song.model;

import dev.kozlofski.accompianist.song.domain.model.Song;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SongTest {

    @Test
    void shouldReturnCorrectMeterFormat() {
        //given
        Song song = new Song();

        //when
        song.setMeter(3,4);

        //then
        assertThat(song.getMeter()).isEqualTo("3/4");
    }

}