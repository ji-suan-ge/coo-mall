package cn.edu.hfut.coomall.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 葛学文
 * @date 2019/7/14 18:06
 */
public class PasswordUtilTest {

    Logger logger = LoggerFactory.getLogger(PasswordUtilTest.class);

    @Test
    public void encodeTest() {

        String plainPassword = "zls123";
        String encodePassword = PasswordUtil.encode(plainPassword);
        logger.debug(encodePassword);
    }
}
