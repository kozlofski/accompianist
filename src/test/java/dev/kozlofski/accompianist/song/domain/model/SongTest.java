package dev.kozlofski.accompianist.song.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void shouldReturnCorrectMeterFormat() {
        //given
        Song song = new Song("New beautiful song", 333);

        //when
        song.setMeter(3,4);

        //then
        assertThat(song.getMeter()).isEqualTo("3/4");
    }

}