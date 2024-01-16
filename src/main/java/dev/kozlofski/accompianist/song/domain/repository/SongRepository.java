package dev.kozlofski.accompianist.song.domain.repository;

import dev.kozlofski.accompianist.song.domain.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
