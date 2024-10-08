package com.book_library;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class BookLibraryApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_NAME", Objects.requireNonNull(dotenv.get("DB_NAME")));
        System.setProperty("DB_USER", Objects.requireNonNull(dotenv.get("DB_USER")));
        System.setProperty("DB_PASSWORD", Objects.requireNonNull(dotenv.get("DB_PASSWORD")));
        System.setProperty("DB_HOST", Objects.requireNonNull(dotenv.get("DB_HOST")));

        SpringApplication.run(BookLibraryApplication.class, args);
    }
}
