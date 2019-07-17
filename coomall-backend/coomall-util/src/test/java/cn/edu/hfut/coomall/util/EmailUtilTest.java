package cn.edu.hfut.coomall.util;

import org.junit.Test;

/**
 * @author 葛学文
 * @date 2019/7/16 21:00
 */
public class EmailUtilTest {

    @Test
    public void sendMailTest() {
        EmailUtil.send("gexuewen@mail.hfut.edu.cn", "测试邮件",
                "这是用于测试邮件的");
    }
}
