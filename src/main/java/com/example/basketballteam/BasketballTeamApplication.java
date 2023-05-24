package com.example.basketballteam;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.basketballteam.mapper")
public class BasketballTeamApplication {
    private static Logger logger = LoggerFactory.getLogger(BasketballTeamApplication.class);
    public static void main(String[] args) {
        logger.info("shiro-demo服务启动.......");
        SpringApplication.run(BasketballTeamApplication.class, args);
    }

}
