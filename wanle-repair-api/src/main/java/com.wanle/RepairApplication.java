package com.wanle;

/**
 * class_name: RepairApplication
 * package: com.wanle
 * describe: TODO
 * creat_user: ningyijie@finupgroup.com
 * creat_date: 2018/3/1
 * creat_time: 下午7:00
 **/

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * EnableAutoConfiguration: Spring Boot会自动根据你jar包的依赖来自动配置项目,Spring Boot建议只有一个带有该注解的类。
 *                          （开启自动配置）注解通常都放到main所在类的上面,如果还有其他路径，则需要增加@ComponentScan
 *  SpringBootApplication 等同于默认的属性的 @Configuration, @EnableAutoConfiguration and @ComponentScan。
 * 					     注意，@ComponentScan 不能凭空使用。使用@SpringbootApplication注解
 * 					     可以解决根类或者配置类（我自己的说法，就是main所在类）头上注解过多的问题.
 * RestController: 是一类特殊的@Controller，它的返回值直接作为HTTP Response的Body部分返回给浏览器。
 *                 controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 *                 RestController 注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 *                 RestController注解Controller，则Controller中的方法无法返回jsp页面.
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = {MybatisAutoConfiguration.class})
@EnableAsync
@ServletComponentScan
@EnableSwagger2Doc
@EnableSwagger2
@EnableTransactionManagement
public class RepairApplication extends SpringBootServletInitializer {
    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RepairApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RepairApplication.class,args);
    }
}
