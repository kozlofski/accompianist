package dev.kozlofski.accompianist.song.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tonalities")
public class Tonality {
    @Id
    private int id;

    private int key; // semitones from C, key is stored here
    private char keyName; // for displaying
    private Accidental accidental; // B = bb, b = b, s = #, S = ##, X #fixme maybe change it to String like "flat", or enum
    private Scale scale;

    @OneToOne(mappedBy = "tonality")
    private Song song;

    public Tonality(char keyName, Accidental accidental) {
        this.key = (resolveKeyName(keyName) + resolveAccidental(accidental)) % 12; // #fixme unnecessary boxing?
    }

    private int resolveKeyName(char keyName) {
        return switch (keyName) {
            case 'C' -> 0;
            case 'D' -> 2;
            case 'E' -> 4;
            case 'F' -> 5;
            case 'G' -> 7;
            case 'A' -> 9;
            case 'B' -> 11;
            default -> 0;
        };
    }

    protected int resolveAccidental(Accidental accidental) {
        return switch (accidental) {
            case DOUBLE_FLAT -> -2;
            case FLAT -> -1;
            case SHARP -> 1;
            case DOUBLE_SHARP -> 2;
            case NATURAL -> 0;
            default -> 0;
        };
    }

    protected enum Scale {
        MAJOR, MINOR,
        IONIAN, DORIAN, PHRYGIAN, LYDIAN, MYXOLYDIAN, AEOLIAN, LOCRIAN,
        PENTATONIC, DODECAPHONIC
    }

    protected enum Accidental {
        DOUBLE_FLAT, FLAT, NATURAL, SHARP, DOUBLE_SHARP
    }
}
