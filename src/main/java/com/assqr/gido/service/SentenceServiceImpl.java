package com.assqr.gido.service;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.repository.SentenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SentenceServiceImpl implements SentenceService {

    private static final Logger logger = LoggerFactory.getLogger(SentenceServiceImpl.class);

    private final SentenceRepository repository;

    public SentenceServiceImpl(SentenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public SentenceList find(String text, String author) {
        SentenceList sentenceList = new SentenceList();
        sentenceList.setSentenceList(this.repository.find(text, author));

        return sentenceList;
    }

    @Override
    public Sentence get(String id) {
        return this.repository.findOne(id);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(Sentence sentence) { this.repository.insert(sentence); }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void set(Sentence sentence) {
        this.repository.lock(sentence.getId());
        this.repository.update(sentence);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void remove(String id) {
        Sentence target = this.repository.lock(id);
        this.repository.delete(target);
    }

}
