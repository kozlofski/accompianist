package dev.kozlofski.accompianist.song.domain.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "songs")
public class Song {
    private final String name;

    @Id
    private final int id; //#fixme change to more sophisticated id? uuid?

    private String composer;
    @Column(name = "meterbeats")
    private int meterBeats;
    @Column(name = "meterunits")
    private int meterUnits;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Tonality tonality;

//    private String imslpLink;
//    private String youTubeLink;
//    private String melodyLink; //#fixme translation of polish "prymka"

    @ElementCollection
    private Set<String> tags;

    String getMeter() {
        return this.meterBeats + "/" + this.meterUnits;
    }

    void setMeter(int beats, int units) {
        this.setMeterBeats(beats);
        this.setMeterUnits(units);
    }


    boolean sameTonality(Song song) {
        return this.tonality.getKey() == song.tonality.getKey();
    }

    boolean sameTonality(Song song, boolean checkScale) {
        return this.tonality.getKey() == song.tonality.getKey() &&
                this.tonality.getScale() == song.tonality.getScale();
    }

}
