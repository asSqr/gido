package com.assqr.gido.service;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.repository.SentenceRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SentenceServiceImplTests {

    /**
     * Repository クラスをモック化する
     */
    @Mock
    private SentenceRepository sentenceRepository;

    @BeforeEach
    public void before() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * find メソッドのテスト
     */
    @Test
    public void testFind() throws Exception {
        // セットアップ
        String inputText = "優しい";
        String inputAuthor = "中島義道";
        List<Sentence> findResult = new ArrayList<>();
        Mockito.doReturn(findResult).when(sentenceRepository).find(inputText, inputAuthor);
        SentenceServiceImpl target = new SentenceServiceImpl(this.sentenceRepository);

        // ターゲットのメソッドの呼び出し
        SentenceList sentenceList = target.find(inputText, inputAuthor);

        // 検証
        // sentenceRepository.find の戻り値と同じインスタンスを参照していること
        assertSame(findResult, sentenceList.getSentenceList());
        Mockito.verify(sentenceRepository, Mockito.times(1)).find(inputText, inputAuthor);
    }

    /**
     * find メソッドのテスト
     */
    @Test
    public void testGet() throws Exception {
        // セットアップ
        String inputId = "1";
        Sentence findResult = new Sentence();
        Mockito.doReturn(findResult).when(sentenceRepository).findOne(inputId);
        SentenceServiceImpl target = new SentenceServiceImpl(this.sentenceRepository);

        // ターゲットのメソッドの呼び出し
        Sentence result = target.get(inputId);

        // 検証
        assertSame(findResult, result);
        Mockito.verify(sentenceRepository, Mockito.times(1)).findOne(inputId);
    }

    /**
     * add メソッドのテスト
     */
    @Test
    public void testAdd() throws Exception {
        // セットアップ
        Sentence sentence = new Sentence();
        Mockito.doNothing().when(sentenceRepository).insert(sentence);
        SentenceServiceImpl target = new SentenceServiceImpl(this.sentenceRepository);

        // ターゲットのメソッドの呼び出し
       target.add(sentence);

        // 検証
        Mockito.verify(sentenceRepository, Mockito.times(1)).insert(sentence);
    }

    /**
     * set メソッドのテスト
     */
    @Test
    public void testSet() throws Exception {
        // セットアップ
        Sentence sentence = new Sentence();
        sentence.setId("1");
        sentence.setText("変更後テキスト");
        Mockito.doReturn(sentence).when(sentenceRepository).lock(sentence.getId());
        Mockito.doNothing().when(sentenceRepository).update(sentence);
        SentenceServiceImpl target = new SentenceServiceImpl(this.sentenceRepository);

        // ターゲットのメソッドの呼び出し
        target.set(sentence);

        // 検証
        Mockito.verify(sentenceRepository, Mockito.times(1)).lock(sentence.getId());
        Mockito.verify(sentenceRepository, Mockito.times(1)).update(sentence);
    }

    /**
     * remove メソッドのテスト
     */
    @Test
    public void testRemove() throws Exception {
        // セットアップ
        String inputId = "1";
        Sentence sentence = new Sentence();
        Mockito.doReturn(sentence).when(sentenceRepository).lock(inputId);
        Mockito.doNothing().when(sentenceRepository).delete(sentence);
        SentenceServiceImpl target = new SentenceServiceImpl(this.sentenceRepository);

        // ターゲットのメソッドの呼び出し
        target.remove(inputId);

        // 検証
        Mockito.verify(sentenceRepository, Mockito.times(1)).lock(inputId);
        Mockito.verify(sentenceRepository, Mockito.times(1)).delete(sentence);
    }

}
