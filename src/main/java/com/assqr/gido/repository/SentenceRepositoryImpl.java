package com.assqr.gido.repository;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.exception.ResourceNotFoundException;
import com.assqr.gido.repository.mybatis.SentenceMapper;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * SentenceRepository の MyBatis を利用した実装クラス．
 */
@Repository
public class SentenceRepositoryImpl implements SentenceRepository {

    private static final Logger logger = LoggerFactory.getLogger(SentenceRepositoryImpl.class);

    /**
     * SqlSessionTemplate クラスのフィールド
     */
    private final SqlSessionTemplate sqlSessionTemplate;

    /**
     * コンストラクタインジェクションする
     */
    public SentenceRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Sentence> find(String text, String author) {
        return this.sqlSessionTemplate.getMapper(SentenceMapper.class)
                .find(text, author);
    }

    @Override
    public Sentence findOne(String id) {
        Sentence sentence = this.sqlSessionTemplate.getMapper(SentenceMapper.class).get(id);

        if (sentence == null) {
            logger.info("Sentence not found. id={}", id);
            throw new ResourceNotFoundException("Sentence not found.");
        }

        return sentence;
    }

    @Override
    public Sentence lock(String id) {
        Sentence sentence = this.sqlSessionTemplate.getMapper(SentenceMapper.class).lock(id);

        if (sentence == null) {
            logger.info("Sentence not found. id={}", id);
            throw new ResourceNotFoundException("Sentence not found.");
        }

        return sentence;
    }

    @Override
    public void insert(Sentence sentence) {
        this.sqlSessionTemplate.getMapper(SentenceMapper.class).add(sentence);
    }

    @Override
    public void update(Sentence sentence) {
        int affected = this.sqlSessionTemplate.getMapper(SentenceMapper.class).set(sentence);

        if (affected != 1) {
            logger.info("Sentence not found. id={}", sentence.getId());
            throw new ResourceNotFoundException("Sentence not found.");
        }
    }

    @Override
    public void delete(Sentence sentence) {
        int affected = this.sqlSessionTemplate.getMapper(SentenceMapper.class).remove(sentence);

        if (affected != 1) {
            logger.info("Sentence not found. id={}", sentence.getId());
            throw new ResourceNotFoundException("Sentence not found.");
        }
    }

}
