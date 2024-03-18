package ru.saiev.crudtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.saiev.crudtest.entity.Book;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {

    private Long readerId;
    private String name;
    private Book book;
    private List<Book> readingBooks;
}
