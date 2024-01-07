package dev.kozlofski.accompianist.song.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Song {
    private final String name;
    private final int id; //#fixme change to more sophisticated id? uuid?

}
