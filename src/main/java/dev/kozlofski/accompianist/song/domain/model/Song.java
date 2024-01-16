package dev.kozlofski.accompianist.song.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "songs")
public class Song {
    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //

    @Column(length=64)
    private String composer;
    @Column(name = "meterbeats")
    private int meterBeats;
    @Column(name = "meterunits")
    private int meterUnits; // #fixme whole meter to separate entity and @ManyToOne relation?

//    @ManyToOne
//    private Tonality tonality;

//    private String imslpLink; // #fixme maybe a url type or sth?
//    private String youTubeLink;
//    private String melodyLink; // #fixme translation of polish "prymka"

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Tag> tags;


    public String getMeter() {
        return this.meterBeats + "/" + this.meterUnits;
    }

    public void setMeter(int beats, int units) {
        this.setMeterBeats(beats);
        this.setMeterUnits(units);
    }
//
//    boolean sameTonality(Song song) {
//        return this.tonality.getKey() == song.tonality.getKey();
//    }
//
//    boolean sameTonality(Song song, boolean checkScale) {
//        return this.tonality.getKey() == song.tonality.getKey() &&
//                this.tonality.getScale() == song.tonality.getScale();
//    }

}
