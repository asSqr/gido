package com.assqr.gido.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Disabled;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class UnitTestUtil {

    /**
     * LocalDateTime を年月日時分秒で assert する．
     */
    public static void assertDateTimeUntilSeconds(LocalDateTime actual, LocalDateTime expected) throws Exception {
        Assert.notNull(actual, "actual is null");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        assertEquals(expected.format(formatter), actual.format(formatter));
    }

    /**
     * entity を JSON 形式の文字列を変換する．
     */
    public static String entity2JsonText(Object entity) throws Exception {
        return new ObjectMapper().writeValueAsString(entity);
    }

}
