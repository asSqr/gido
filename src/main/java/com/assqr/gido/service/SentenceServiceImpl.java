package com.assqr.gido.service;

import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.repository.SentenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

}
