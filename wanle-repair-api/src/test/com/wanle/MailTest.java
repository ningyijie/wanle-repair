package com.wanle;

import com.wanle.utils.MailUtil;
import freemarker.template.Template;
import io.swagger.models.auth.In;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { RepairApplication.class })
public class MailTest {
    @Autowired
    private MailUtil mailUtil;

    private String to = "897571053@qq.com";

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer; //自动注入

    @Test
    public void sendSimpleMail() {
        mailUtil.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }

    @Test
    public void sendTemplateMail(){

        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(to);
//            List<String> internetAddressList=new ArrayList<>();
//            internetAddressList.add("897571053@qq.com");
//            internetAddressList.add("2669165300@qq.com");
//
//            helper.setTo(internetAddressList.toArray(new String[internetAddressList.size()]));
            String[] to={"897571053@qq.com"};
            helper.setTo(to);


            helper.setSubject("主题：模板邮件");

            Map<String, Object> model = new HashedMap();
            model.put("username", "zggdczfr");

            //修改 application.properties 文件中的读取路径
//      FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//      configurer.setTemplateLoaderPath("classpath:templates");
            //读取 html 模板
//            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
            Template template=new Template(null,new StringReader("<html>\n" +
                    "\n" +
                    "<body>\n" +
                    "\n" +
                    "<h3>你好， ${username}, 这是一封模板邮件!</h3>\n" +
                    "\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>"),null);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }



}
