package cck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Title cck
 * @Copyright: Copyright 2021
 * @Description: java <br/>
 * @Created on 2021/4/18 chenck
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Service2Application {
    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }
}
