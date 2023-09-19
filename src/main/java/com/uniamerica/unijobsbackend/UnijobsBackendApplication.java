package com.uniamerica.unijobsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnijobsBackendApplication {

    public String PORT = System.getenv("PORT");

    public static void main(String[] args) {
        SpringApplication.run(UnijobsBackendApplication.class, args);
    }

}
