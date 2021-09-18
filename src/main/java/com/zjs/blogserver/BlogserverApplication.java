package com.zjs.blogserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//将dao层中的映射接口注入到容器中
@MapperScan("com.zjs.blogserver.dao")
@SpringBootApplication
public class BlogserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogserverApplication.class, args);
    }

}
