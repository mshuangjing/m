package com.byzoro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan("com.byzoro.mapper")
public class CuProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuProjectApplication.class, args);
    }

}
