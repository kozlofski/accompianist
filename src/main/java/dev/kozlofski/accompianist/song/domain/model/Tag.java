package dev.kozlofski.accompianist.song.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    private int id;
    private String name;
}
