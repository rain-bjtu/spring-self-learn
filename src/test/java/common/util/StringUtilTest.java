package common.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeatString() {
        String s = "-";
        int times = 1000;
        String result = StringUtil.repeatString(s, times);
        Assert.assertEquals(times, result.length());

        times = 111;
        result = StringUtil.repeatString(s, times);
        Assert.assertEquals(times, result.length());
    }
}
