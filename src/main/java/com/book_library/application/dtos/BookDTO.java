package com.book_library.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDTO (
        @NotBlank String title,
        @NotBlank String author,
        @NotBlank String genre,
        @NotBlank String isbn,
        @NotNull int publicationYear
) {
}
