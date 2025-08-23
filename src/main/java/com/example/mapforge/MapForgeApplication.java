package com.example.mapforge;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapForgeApplication {

    public static void main(String[] args) {
        var dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Set environment variables so Spring Boot can use them
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );

        SpringApplication.run(MapForgeApplication.class, args);
    }

}
