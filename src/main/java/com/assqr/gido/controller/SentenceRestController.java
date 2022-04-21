package com.assqr.gido.controller;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.service.SentenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sentences")
public class SentenceRestController {

    private static final Logger logger = LoggerFactory.getLogger(SentenceRestController.class);

    private final SentenceService service;

    public SentenceRestController(SentenceService service) {
        this.service = service;
    }

    /**
     * 文章取得処理
     *
     * @param text 検索文字列 (Optional)
     * @param author 著者 (Optional)
     * @return 条件に合致した文章のリスト
     */
    @GetMapping(path = "", produces = "application/json")
    public SentenceList find(@RequestParam(name = "text", required = false) String text,
                             @RequestParam(name = "author", required = false) String author) {
        return this.service.find(text, author);
    }

    /**
     * id 指定による 1 件参照処理
     *
     * @param sentenceId 文章の id
     * @return 対応する文章
     */
    @GetMapping(path = "/{sentenceId}", produces = "application/json")
    public Sentence get(@PathVariable String sentenceId) { return this.service.get(sentenceId); }

    /**
     * 文章新規登録処理
     *
     * @param sentence 登録する文章
     */
    @PostMapping(path = "", produces = "application/json")
    public void add(@RequestBody Sentence sentence) { this.service.add(sentence); }

    /**
     * id 指定による 1 件更新処理
     *
     * @param sentenceId 更新する文章の id
     * @param sentence 更新内容
     */
    @PatchMapping(path = "/{sentenceId}", produces = "application/json")
    public void set(@PathVariable String sentenceId, @RequestBody Sentence sentence) {
        sentence.setId(sentenceId);
        this.service.set(sentence);
    }

    /**
     * id 指定による 1 件削除処理
     *
     * @param sentenceId 削除する文章 id
     */
    @DeleteMapping(path = "/{sentenceId}", produces = "application/json")
    public void remove(@PathVariable String sentenceId) { this.service.remove(sentenceId); }

}
