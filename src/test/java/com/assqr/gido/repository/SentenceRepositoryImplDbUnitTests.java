package com.assqr.gido.repository;

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
 */
public class SentenceRepositoryImplDbUnitTests {

    /**
     * SELECT を検証するテスト
     */
    @SpringBootTest(classes = GidoApplication.class)
    @TestExecutionListeners( {DependencyInjectionTestExecutionListener.class, FindTestExecutionListener.class} )
    @Nested
    public class FindDbTest extends AbstractTestExecutionListener {

        @Autowired
        private SentenceRepository target;

        /**
         * find メソッドの全件検索のテスト
         */
        @Test
        public void testFindAll() throws Exception {
            List<Sentence> sentences = target.find(null, null);
            assertEquals(5, sentences.size());
            assertEquals("1", sentences.get(0).getId());
            assertEquals("2", sentences.get(1).getId());
            assertEquals("3", sentences.get(2).getId());
            assertEquals("4", sentences.get(3).getId());
            assertEquals("5", sentences.get(4).getId());
        }

        /**
         * findList メソッドの検索文字列・著者による検索のテスト
         */
        @Test
        public void testFindFilteredByTextAndAuthor() throws Exception {
            List<Sentence> sentences = target.find("優しい", "中島義道");
            assertEquals(1, sentences.size());
            assertEquals("1", sentences.get(0).getId());
            assertEquals("中島義道", sentences.get(0).getAuthor());
            assertEquals("「優しい」人とは、――他人に優しくしようと全力を尽くそうとする人ではなくて――優しくない他人によって自分が傷つくことを全身で恐れる人であり、むしろこちらを第一原理とする人なのである。『うるさい日本の私』\\n18\\n60",
                    sentences.get(0).getText());
        }

        /**
         * findOne メソッドのテスト
         */
        @Test
        public void testGet() throws Exception {
            Sentence sentence = target.findOne("1");
            assertNotNull(sentence);
            assertEquals("1", sentence.getId());
            assertEquals("中島義道", sentence.getAuthor());
            assertEquals("「優しい」人とは、――他人に優しくしようと全力を尽くそうとする人ではなくて――優しくない他人によって自分が傷つくことを全身で恐れる人であり、むしろこちらを第一原理とする人なのである。『うるさい日本の私』\\n18\\n60",
                    sentence.getText());
        }

        /**
         * findOne メソッドの例外発生時のテスト
         */
        @Test
        public void testGetException() throws Exception {
            assertThrows(ResourceNotFoundException.class, () -> target.findOne("0"));
        }

        /**
         * lock メソッドのテスト
         */
        @Test
        public void testLock() throws Exception {
            Sentence sentence = target.lock("1");
            assertNotNull(sentence);
            assertEquals("1", sentence.getId());
            assertEquals("中島義道", sentence.getAuthor());
            assertEquals("「優しい」人とは、――他人に優しくしようと全力を尽くそうとする人ではなくて――優しくない他人によって自分が傷つくことを全身で恐れる人であり、むしろこちらを第一原理とする人なのである。『うるさい日本の私』\\n18\\n60",
                    sentence.getText());
        }

        /**
         * lock メソッドの例外発生時のテスト
         */
        @Test
        public void testLockException() throws Exception {
            assertThrows(ResourceNotFoundException.class, () -> target.lock("0"));
        }

    }

    static class FindTestExecutionListener extends AbstractTestExecutionListener {

    }

}
