package org.sparkliang.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.sparkliang")
public class ServerApp {
    public static void main(String[] args) {
        System.setProperty("server.port", "9090");
        SpringApplication.run(ServerApp.class, args);
    }
}
