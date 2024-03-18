package ru.saiev.crudtest.service;

import ru.saiev.crudtest.dto.ReaderDto;

import java.util.List;

public interface ReaderService {

    ReaderDto createReader(ReaderDto readerDto);

    ReaderDto getReaderById(Long readerId);

    List<ReaderDto> getAllReaders();

    ReaderDto updateReader(ReaderDto readerDto);

    void deleteReader(Long readerId);
}
