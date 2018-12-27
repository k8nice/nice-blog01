package com.nice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 启动类
 * @author nice
 */
@SpringBootApplication
@CrossOrigin
@EnableDubboConfig
public class NiceConsumerApplication {

    /**
     * 主函数开启
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(NiceConsumerApplication.class, args);
    }

}

