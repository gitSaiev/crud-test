package ru.saiev.crudtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saiev.crudtest.dto.BookDto;
import ru.saiev.crudtest.entity.Book;
import ru.saiev.crudtest.mapper.AutoBookMapper;
import ru.saiev.crudtest.repository.BookRepository;
import ru.saiev.crudtest.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = AutoBookMapper.MAPPER.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);

        return AutoBookMapper.MAPPER.mapToBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);

        return AutoBookMapper.MAPPER.mapToBookDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books
                .stream()
                .map(AutoBookMapper.MAPPER::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book existingBook = bookRepository.findById(bookDto.getBookId()).orElseThrow();
        existingBook.setName(bookDto.getName());
        existingBook.setReader(bookDto.getReader());
        existingBook.setReaders(bookDto.getReaders());

        Book updatedBook = bookRepository.save(existingBook);

        return AutoBookMapper.MAPPER.mapToBookDto(updatedBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
