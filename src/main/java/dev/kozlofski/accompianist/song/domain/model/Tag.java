package dev.kozlofski.accompianist.song.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Song> songs;
}
