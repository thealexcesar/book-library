package com.book_library.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String author;
    private String genre;
    private String isbn;

    @Column(unique = true)
    private String title;
    private int publicationYear;
}
