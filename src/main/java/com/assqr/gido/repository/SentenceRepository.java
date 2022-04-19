package com.assqr.gido.repository;

import com.assqr.gido.domain.Sentence;
import java.util.List;

/**
 * Sentence オブジェクトのレポジトリ
 */
public interface SentenceRepository {

    /**
     * 全文章取得
     *
     * @return 全文章のリスト
     */
    List<Sentence> findAll();

    /**
     * text を含む文章を取得
     *
     * @param text 検索文字列
     * @return 検索文字列を含む文章のリスト
     */
    List<Sentence> findList(String text);

}
