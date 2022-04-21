package com.assqr.gido.repository;

import com.assqr.gido.domain.Sentence;
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

    public List<Sentence> find(String text, String author) {
        return this.sqlSessionTemplate.getMapper(SentenceMapper.class)
                .find(text, author);
    }

}
