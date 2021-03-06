package com.exfantasy.template;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <pre>
 * 程式啟動點 
 * </pre>
 * 
 * @author tommy.feng
 *
 */
//@Configuration // 這邊使用 Java Class 作為設定，而非XML
//@EnableAutoConfiguration // 啟用 Spring Boot 自動配置，將自動判斷專案使用到的套件，建立相關的設定。
//@ComponentScan( basePackages = {"com.exfantasy.template"} ) // 自動掃描 Spring Bean 元件
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application extends SpringBootServletInitializer {
	
	private final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@PostConstruct
	public void started() {
		logger.info(">>>>> Application started <<<<<");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		ApplicationContext ctx = SpringApplication.run(Application.class, args);
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
