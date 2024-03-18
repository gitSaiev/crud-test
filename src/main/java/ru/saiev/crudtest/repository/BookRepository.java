package ru.saiev.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saiev.crudtest.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
