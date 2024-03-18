package ru.saiev.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saiev.crudtest.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
