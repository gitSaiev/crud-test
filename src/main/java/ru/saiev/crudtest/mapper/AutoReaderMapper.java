package ru.saiev.crudtest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.saiev.crudtest.dto.ReaderDto;
import ru.saiev.crudtest.entity.Reader;

@Mapper(componentModel = "spring")
public interface AutoReaderMapper {
    AutoReaderMapper MAPPER = Mappers.getMapper(AutoReaderMapper.class);

    ReaderDto maptoReaderDto(Reader reader);
    Reader mapToReader(ReaderDto readerDto);
}
