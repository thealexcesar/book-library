package com.book_library.utils;

import com.book_library.application.dtos.BookDTO;
import com.book_library.domain.models.BookModel;

public class BookConverter  {
    public static BookDTO toDTO(BookModel model) {
        return new BookDTO(
                model.getTitle(),
                model.getAuthor(),
                model.getGenre(),
                model.getIsbn(),
                model.getPublicationYear()
        );
    }

    public static BookModel toEntity(BookDTO dto) {
        return new BookModel(
                null,
                dto.author(),
                dto.genre(),
                dto.isbn(),
                dto.title(),
                dto.publicationYear()
        );
    }
}
