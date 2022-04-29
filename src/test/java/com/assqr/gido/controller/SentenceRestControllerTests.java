package com.assqr.gido.controller;

import com.assqr.gido.domain.Sentence;
import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.service.SentenceService;
import com.assqr.gido.util.UnitTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Controller のテスト
 */
public class SentenceRestControllerTests {

    /**
     * Service クラスをモック化する
     */
    @Mock
    private SentenceService sentenceService;

    /**
     * SentenceRestController クラスにモックを注入する
     */
    @InjectMocks
    private SentenceRestController target;

    private MockMvc mockMvc;

    @BeforeEach
    public void before() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(target).setMessageConverters().build();
    }

    /**
     * 検索文字列と著者による検索テスト
     */
    @Test
    public void testFind() throws Exception {
        SentenceList findResult = new SentenceList();
        Mockito.doReturn(findResult).when(sentenceService).find("誇り高く弱い若者たちよ!", "中島義道");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/sentences")
                .param("text", "誇り高く弱い若者たちよ!").param("author", "中島義道"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
        Mockito.verify(sentenceService, Mockito.times(1)).find("誇り高く弱い若者たちよ!", "中島義道");
    }

    /**
     * null を指定した場合の検索
     */
    @Test
    public void testFindWhenNullParameter() throws Exception {
        SentenceList findResult = new SentenceList();
        Mockito.doReturn(findResult).when(sentenceService).find(null, null);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/sentences")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(sentenceService, Mockito.times(1)).find(null, null);
        assertEquals(UnitTestUtil.entity2JsonText(findResult), result.getResponse().getContentAsString());
    }

    /**
     * id による 1 件取得のテスト
     */
    @Test
    public void testGet() throws Exception {
        String inputId = "1";
        Sentence getResult = new Sentence();
        Mockito.doReturn(getResult).when(sentenceService).get(inputId);

        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/sentences/" + inputId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertEquals(UnitTestUtil.entity2JsonText(getResult), result.getResponse().getContentAsString());
        Mockito.verify(sentenceService, Mockito.times(1)).get(inputId);
    }

    /**
     * Sentence の新規登録処理のテスト
     */
    @Test
    public void testAdd() throws Exception {
        Mockito.doNothing().when(sentenceService).add(ArgumentMatchers.any(Sentence.class));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/sentences")
                .contentType(MediaType.APPLICATION_JSON).content(UnitTestUtil.entity2JsonText(new Sentence())));

        Mockito.verify(sentenceService, Mockito.times(1)).add(ArgumentMatchers.any(Sentence.class));
    }

    /**
     * id 指定による 1 件更新処理のテスト
     */
    @Test
    public void testSet() throws Exception {
        String inputId = "1";
        ArgumentMatcher<Sentence> matcher = argument -> {
            assertEquals(inputId, argument.getId());

            return true;
        };

        Mockito.doNothing().when(sentenceService).set(Mockito.argThat(matcher));

        mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/v1/sentences/" + inputId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UnitTestUtil.entity2JsonText(new Sentence())));

        Mockito.verify(sentenceService, Mockito.times(1)).set(Mockito.argThat(matcher));
    }

    /**
     * id 指定による 1 件削除処理のテスト
     */
    @Test
    public void testRemove() throws Exception {
        String inputId = "1";
        Mockito.doNothing().when(sentenceService).remove(inputId);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/sentences/" + inputId));

        Mockito.verify(sentenceService, Mockito.times(1)).remove(inputId);
    }

}
