package com.assqr.gido.repository;

import com.assqr.gido.domain.Sentence;
import java.util.List;

/**
 * Sentence オブジェクトのレポジトリ
 */
public interface SentenceRepository {

    /**
     * text を含む文章を取得
     *
     * @param text 検索文字列
     * @param author 著者
     * @return 指定した著者の検索文字列を含む文章のリスト
     */
    List<Sentence> find(String text, String author);

}
