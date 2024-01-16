package dev.kozlofski.accompianist.song.service;

import dev.kozlofski.accompianist.song.domain.model.Tag;
import dev.kozlofski.accompianist.song.domain.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional(readOnly = true)
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Tag getTag(int id) {
        return tagRepository.getById(id); // #fixme deprecated
    }

    @Transactional
    public Tag createTag(Tag tagRequest) {
        Tag tag = new Tag();
        tag.setName(tagRequest.getName());

        return tagRepository.save(tag);
    }

    @Transactional
    public Tag updateTag(int id, Tag tagRequest) {
        Tag tag = tagRepository.getById(id);

//        tag.setComposer(tagRequest.getComposer());

        return tagRepository.save(tag);
    }

    @Transactional
    public void deleteTag(int id) {
        tagRepository.deleteById(id);
    }
}
