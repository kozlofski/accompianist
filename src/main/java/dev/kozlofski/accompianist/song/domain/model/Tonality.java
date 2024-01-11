package dev.kozlofski.accompianist.song.domain.model;

import lombok.Data;

@Data
public class Tonality {
    private int key; // semitones from C, key is stored here
    private char keyName; // for displaying
    private char Accidental; // B = bb, b = b, s = #, S = ##, X
    private Scale scale;

    public Tonality(char keyName, char accidental) {
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

    private int resolveAccidental(char accidental) {
        return switch (accidental) {
            case 'B' -> -2;
            case 'b' -> -1;
            case 's' -> 1;
            case 'S' -> 2;
            default -> 0;
        };
    }

    private enum Scale {
        MAJOR, MINOR,
        IONIAN, DORIAN, PHRYGIAN, LYDIAN, MYXOLYDIAN, AEOLIAN, LOCRIAN,
        PENTATONIC, DODECAPHONIC
    }
}
