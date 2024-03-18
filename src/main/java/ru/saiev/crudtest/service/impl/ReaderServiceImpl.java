package ru.saiev.crudtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saiev.crudtest.dto.ReaderDto;
import ru.saiev.crudtest.entity.Reader;
import ru.saiev.crudtest.mapper.AutoReaderMapper;
import ru.saiev.crudtest.repository.ReaderRepository;
import ru.saiev.crudtest.service.ReaderService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    @Override
    public ReaderDto createReader(ReaderDto readerDto) {
        Reader reader = AutoReaderMapper.MAPPER.mapToReader(readerDto);
        Reader savedReader = readerRepository.save(reader);

        return AutoReaderMapper.MAPPER.maptoReaderDto(savedReader);
    }

    @Override
    public ReaderDto getReaderById(Long readerId) {
        Reader reader = readerRepository.findById(readerId).orElse(null);

        return AutoReaderMapper.MAPPER.maptoReaderDto(reader);
    }

    @Override
    public List<ReaderDto> getAllReaders() {
        List<Reader> readers = readerRepository.findAll();

        return readers
                .stream()
                .map(AutoReaderMapper.MAPPER::maptoReaderDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReaderDto updateReader(ReaderDto readerDto) {
        Reader existingReader = readerRepository.findById(readerDto.getReaderId()).orElseThrow();
        existingReader.setReadingBooks(readerDto.getReadingBooks());
        existingReader.setBook(readerDto.getBook());
        existingReader.setName(readerDto.getName());

        Reader updatedReader = readerRepository.save(existingReader);

        return AutoReaderMapper.MAPPER.maptoReaderDto(updatedReader);
    }

    @Override
    public void deleteReader(Long readerId) {
        readerRepository.deleteById(readerId);
    }
}
