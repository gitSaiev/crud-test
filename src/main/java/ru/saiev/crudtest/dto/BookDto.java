package ru.saiev.crudtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.saiev.crudtest.entity.Reader;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long bookId;
    private String name;
    private Reader reader;
    private List<Reader> readers;
}
