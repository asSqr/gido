package com.assqr.gido.repository.mybatis;

import com.assqr.gido.domain.Sentence;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * MyBatis による Sentence テーブルとのマッパーを表すインターフェース．
 */
public interface SentenceMapper {

    List<Sentence> find(@Param("text") String text, @Param("author") String author);

}
