package com.assqr.gido.service;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.domain.SentenceList;

/**
 * Sentence ドメインオブジェクトに関する処理をするモジュールを表すインターフェース．
 */
public interface SentenceService {

    /**
     * 著者を指定した検索文字列を含む文章を取得
     *
     * @param text 検索文字列
     * @param author 著者
     * @return 対応する文章のリスト
     */
    SentenceList find(String text, String author);

    /**
     * 文章の取得
     *
     * @param id 文章の id
     * @return 対応する文章
     */
    Sentence get(String id);

    /**
     * 文章の保存
     *
     * @param sentence 保存する文章
     */
    void add(Sentence sentence);

    /**
     * 文章の更新
     *
     * @param sentence 更新する文章
     */
    void set(Sentence sentence);

    /**
     * 文章の削除
     *
     * @param id 削除する文章
     */
    void remove(String id);

}
