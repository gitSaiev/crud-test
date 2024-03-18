package ru.saiev.crudtest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.saiev.crudtest.dto.BookDto;
import ru.saiev.crudtest.entity.Book;

@Mapper(componentModel = "spring")
public interface AutoBookMapper {
    AutoBookMapper MAPPER = Mappers.getMapper(AutoBookMapper.class);

    BookDto mapToBookDto(Book book);
    Book mapToBook(BookDto bookDto);
}
