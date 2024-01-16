package dev.kozlofski.accompianist.song.controller;

import dev.kozlofski.accompianist.song.domain.model.Song;
import dev.kozlofski.accompianist.song.domain.model.Tag;
import dev.kozlofski.accompianist.song.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    List<Tag> getSongs() {
        return tagService.getTags();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Tag getTag(@PathVariable int id) {
        return tagService.getTag(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Tag updateSong(@PathVariable int id, @RequestBody Tag tag) {
        return tagService.updateTag(id, tag);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSong(@PathVariable int id) {
        tagService.deleteTag(id);
    }
}
