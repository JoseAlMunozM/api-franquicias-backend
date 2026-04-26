package com.franquiciasJamm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.franquiciasJamm.infrastructure.repository")
public class ApiFranquiciasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFranquiciasApplication.class, args);
    }
}