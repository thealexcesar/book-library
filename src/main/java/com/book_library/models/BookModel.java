package com.book.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String autor;
    private String genero;
    private int ano;
    private LocalDateTime createdAt = LocalDateTime.now();
}
