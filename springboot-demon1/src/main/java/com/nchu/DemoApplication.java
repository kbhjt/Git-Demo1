package com.nchu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication
 * 声明我们的SpringBoot入口类
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //使用SpringApplication的静态方法 启动springboot程序
        SpringApplication.run(DemoApplication.class,args);
    }
}
