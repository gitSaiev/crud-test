package ru.saiev.crudtest.service;

import ru.saiev.crudtest.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long bookId);

    List<BookDto> getAllBooks();

    BookDto updateBook(BookDto bookDto);

    void deleteBook(Long bookId);
}
