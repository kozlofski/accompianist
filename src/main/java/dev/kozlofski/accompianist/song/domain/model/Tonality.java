package dev.kozlofski.accompianist.song.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class Tonality {
    @Id
    private int id;

    private Key key;
    private Scale scale;

//    @OneToMany
//    private Set<Song> songs;

    public boolean enharmonicEquals() { //#fixme
        return false;
    }

    @Getter
    enum Key {
        C_DOUBLEFLAT(10), C_FLAT(11), C(0), C_SHARP(1), C_DOUBLESHARP(2),
        D_DOUBLEFLAT(0), D_FLAT(1), D(2), D_SHARP(3),
        E_FLAT(3), E(4), F(5), F_SHARP(6), G_FLAT(6),
        G(7), G_SHARP(8), A_FLAT(8), A(9), A_SHARP(10),
        B_FLAT(10), B(11),
        KEYLESS(0); // #fixme add all possible keys

        private final int value;

        Key(int value) {
            this.value = value;
        }
    }

    enum Scale {
        MAJOR, MINOR,
        IONIAN, DORIAN, PHRYGIAN, LYDIAN, MYXOLYDIAN, AEOLIAN, LOCRIAN,
        PENTATONIC,
        DODECAPHONIC, ATONAL
    }
}
