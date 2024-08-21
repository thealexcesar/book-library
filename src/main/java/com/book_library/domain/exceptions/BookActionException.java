package com.book_library.domain.exceptions;

public class BookActionException extends RuntimeException {
    public BookActionException(String action, String message) {
        super(String.format("Error %s book: %s", action, message)) ;
    }
}
