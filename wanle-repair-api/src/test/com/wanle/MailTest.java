package com.wanle;


import com.wanle.utils.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { RepairApplication.class })
public class MailTest {
    @Autowired
    private MailUtil mailUtil;

    private String to = "897571053@qq.com";

    @Test
    public void sendSimpleMail() {
        mailUtil.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }

}
