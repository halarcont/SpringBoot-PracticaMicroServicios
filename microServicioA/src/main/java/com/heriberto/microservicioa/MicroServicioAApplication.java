package com.heriberto.microservicioa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroServicioAApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicioAApplication.class, args);
    }

}
