package com.assqr.gido.service;

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

}
