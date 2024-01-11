package dev.kozlofski.accompianist.song.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TonalityTest {

    @Test
    public void shouldResolveSharpAccidental() {
        // given
        Tonality tonality = new Tonality('C', 's');

        //then
        assertThat(tonality.getKey()).isEqualTo(1);
    }

    @Test
    public void shouldResolveBSharpAccidental() {
        // given
        Tonality tonality = new Tonality('B', 's');

        //then
        assertThat(tonality.getKey()).isEqualTo(0);
    }

}