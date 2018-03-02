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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@ServletComponentScan
@EnableSwagger2Doc
@EnableTransactionManagement
public class RepairApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairApplication.class,args);
    }
}
