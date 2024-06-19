package com.example.library_direccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("com.example.library_direccion.repository")
@EntityScan("com.example.library_direccion.model")
public class LibraryDireccionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryDireccionApplication.class, args);
    }
}
