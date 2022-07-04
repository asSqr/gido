/*package com.assqr.gido.repository;

import com.assqr.gido.GidoApplication;
import com.assqr.gido.domain.Sentence;
import com.assqr.gido.exception.ResourceNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * アプリケーションで実装した SQL をテストする．DB に接続して SQL を実行する．
 *
/*public class SentenceRepositoryImplDbUnitTests {

    /**
     * SELECT を検証するテスト
     *
    @SpringBootTest(classes = GidoApplication.class)
    @TestExecutionListeners( {DependencyInjectionTestExecutionListener.class, FindTestExecutionListener.class} )
    @Nested
    public class FindDbTest extends AbstractTestExecutionListener {

        @Autowired
        private SentenceRepository target;

        /**
         * find メソッドの全件検索のテスト
         *
        @Test
        public void testFindAll() throws Exception {
            List<Sentence> sentences = target.find(null, null);
            assertEquals(1000, sentences.size());
        }

        /**
         * findList メソッドの検索文字列・著者による検索のテスト
         *
        @Test
        public void testFindFilteredByTextAndAuthor() throws Exception {
            List<Sentence> sentences = target.find("誇り高く弱い若者たちよ!", "中島義道");
            assertEquals(2, sentences.size());
            assertEquals("827e2ab2-bd2b-4277-b217-f48a89c1d95a", sentences.get(0).getId());
            assertEquals("中島義道 bot", sentences.get(0).getAuthor());
            assertEquals("誇り高く弱い若者たちよ!ニーチェを読もう。そして、思いっきり自分と重ね合わせて、自分のバイブルにしよう。そして、世の中の「畜群」どもをすべて笑い飛ばそう。そうすれば、あと少しは自分をごまかせるかも知れないのだから。『善人ほど悪い奴はいない』",
                    sentences.get(0).getText());
            assertEquals("c1be8661-4581-4d9a-85b6-4b876930f920", sentences.get(1).getId());
        }

        /**
         * findOne メソッドのテスト
         *
        @Test
        public void testGet() throws Exception {
            Sentence sentence = target.findOne("827e2ab2-bd2b-4277-b217-f48a89c1d95a");
            assertNotNull(sentence);
            assertEquals("827e2ab2-bd2b-4277-b217-f48a89c1d95a", sentence.getId());
            assertEquals("中島義道 bot", sentence.getAuthor());
            assertEquals("誇り高く弱い若者たちよ!ニーチェを読もう。そして、思いっきり自分と重ね合わせて、自分のバイブルにしよう。そして、世の中の「畜群」どもをすべて笑い飛ばそう。そうすれば、あと少しは自分をごまかせるかも知れないのだから。『善人ほど悪い奴はいない』",
                    sentence.getText());
        }

        /**
         * findOne メソッドの例外発生時のテスト
         *
        @Test
        public void testGetException() throws Exception {
            assertThrows(ResourceNotFoundException.class, () -> target.findOne("0"));
        }

        /**
         * lock メソッドのテスト
         *
        @Test
        public void testLock() throws Exception {
            Sentence sentence = target.lock("827e2ab2-bd2b-4277-b217-f48a89c1d95a");
            assertNotNull(sentence);
            assertEquals("827e2ab2-bd2b-4277-b217-f48a89c1d95a", sentence.getId());
            assertEquals("中島義道 bot", sentence.getAuthor());
            assertEquals("誇り高く弱い若者たちよ!ニーチェを読もう。そして、思いっきり自分と重ね合わせて、自分のバイブルにしよう。そして、世の中の「畜群」どもをすべて笑い飛ばそう。そうすれば、あと少しは自分をごまかせるかも知れないのだから。『善人ほど悪い奴はいない』",
                    sentence.getText());
        }

        /**
         * lock メソッドの例外発生時のテスト
         *
        @Test
        public void testLockException() throws Exception {
            assertThrows(ResourceNotFoundException.class, () -> target.lock("0"));
        }

    }

    static class FindTestExecutionListener extends AbstractTestExecutionListener {

    }

}*/
