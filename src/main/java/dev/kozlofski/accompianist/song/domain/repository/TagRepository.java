package dev.kozlofski.accompianist.song.domain.repository;

import dev.kozlofski.accompianist.song.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
