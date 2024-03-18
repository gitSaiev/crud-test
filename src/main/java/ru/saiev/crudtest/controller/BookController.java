package ru.saiev.crudtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.saiev.crudtest.dto.BookDto;
import ru.saiev.crudtest.exception.BookNotFoundException;
import ru.saiev.crudtest.service.BookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable("id") Long bookId) {
        BookDto book = bookService.getBookById(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book not found: " + bookId);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();

        if (books.isEmpty()) {
            throw new BookNotFoundException("Book list is empty");
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.createBook(bookDto);

        if (bookService.getBookById(bookDto.getBookId()) != null) {
            throw new BookNotFoundException("Book with this id already exists");
        }

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId, @RequestBody BookDto bookDto) {
        if (bookService.getBookById(bookId) == null) {
            throw new BookNotFoundException("Book this id is not found " + bookId);
        }

        bookDto.setBookId(bookId);
        BookDto updatedBook = bookService.updateBook(bookDto);

        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        if (bookService.getBookById(bookId) == null) {
            throw new BookNotFoundException("Book this id is not found " + bookId);
        }

        bookService.deleteBook(bookId);

        return new ResponseEntity<>("Book was removed", HttpStatus.OK);
    }

}
