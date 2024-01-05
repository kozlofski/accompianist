package dev.kozlofski.accompianist;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Song {
    private final String name;
    private final int id;

}
