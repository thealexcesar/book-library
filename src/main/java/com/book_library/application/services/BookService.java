package com.book_library.application.services;

import com.book_library.application.dtos.BookDTO;
import com.book_library.domain.exceptions.BookActionException;
import com.book_library.domain.models.BookModel;
import com.book_library.infrastructure.repositories.BookRepository;
import com.book_library.utils.BookConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<BookDTO>> findAll() {
        var books = bookRepository.findAll().stream()
                .map(BookConverter::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<BookDTO> addBook(BookDTO dto) {
        try {
            BookModel book = BookConverter.toEntity(dto);
            BookModel savedBook = bookRepository.save(book);
            var location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(savedBook.getId()).toUri();
            BookDTO savedBookDTO = BookConverter.toDTO(savedBook);
            return ResponseEntity.created(location).body(savedBookDTO);
        } catch (Exception e) {
            throw new BookActionException("create", e.getMessage());
        }
    }
}