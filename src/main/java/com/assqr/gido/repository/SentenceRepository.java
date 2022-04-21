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

    /**
     * 特定の文章の取得
     *
     * @param id 取得する文章の id
     * @return 対応する文章
     */
    Sentence findOne(String id);

    /**
     * id 指定による行ロック
     *
     * @param id ロックする id
     * @return ロックされた文章
     */
    Sentence lock(String id);

    /**
     * 文章の保存
     *
     * @param sentence 保存する文章
     */
    void insert(Sentence sentence);

    /**
     * 文章の更新
     *
     * @param sentence 更新する文章
     */
    void update(Sentence sentence);

    /**
     * 文章の削除
     *
     * @param sentence 削除する文章
     */
    void delete(Sentence sentence);

}
