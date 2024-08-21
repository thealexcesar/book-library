package com.book_library.infrastructure.repositories;

import com.book_library.domain.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    List<BookModel> findByGenre(String genre);
}
