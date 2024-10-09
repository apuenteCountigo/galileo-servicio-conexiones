package com.galileo.cu.servicioconexiones;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({ "com.galileo.cu.commons.models" })
public class ServicioConexionesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServicioConexionesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************************************");
        System.out.println("Conexiones V1.1-24-10-09 13:18");
    }
}
