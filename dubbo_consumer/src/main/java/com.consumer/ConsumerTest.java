package com.consumer;

import com.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author-liudongxu
 * @created 2018-11-13 17:26
 */
public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:springmvc.xml" });

        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");

        System.out.println(demoService.sayHello(" worl!"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
