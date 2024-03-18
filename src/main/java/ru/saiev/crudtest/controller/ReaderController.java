package ru.saiev.crudtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.saiev.crudtest.dto.ReaderDto;
import ru.saiev.crudtest.exception.ReaderNotFoundException;
import ru.saiev.crudtest.service.ReaderService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/readers")
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("{id}")
    public ResponseEntity<ReaderDto> getReader(@PathVariable("id") Long readerId) {
        ReaderDto reader = readerService.getReaderById(readerId);

        if (reader == null) {
            throw new ReaderNotFoundException("Reader not found: " + readerId);
        }

        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        List<ReaderDto> readers = readerService.getAllReaders();

        if (readers.isEmpty()) {
            throw new ReaderNotFoundException("Reader list is empty");
        }

        return new ResponseEntity<>(readers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReaderDto> createReader(@RequestBody ReaderDto readerDto) {
        ReaderDto savedBook = readerService.createReader(readerDto);

        if (readerService.getReaderById(readerDto.getReaderId()) != null) {
            throw new ReaderNotFoundException("Reader with this id already exists");
        }

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReaderDto> updateReader(@PathVariable("id") Long readerId, @RequestBody ReaderDto readerDto) {
        if (readerService.getReaderById(readerId) == null) {
            throw new ReaderNotFoundException("Reader this id is not found " + readerId);
        }

        readerDto.setReaderId(readerId);
        ReaderDto reader = readerService.updateReader(readerDto);

        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReader(@PathVariable("id") Long readerId) {
        if (readerService.getReaderById(readerId) == null) {
            throw new ReaderNotFoundException("Reader this id is not found " + readerId);
        }

        readerService.deleteReader(readerId);

        return new ResponseEntity<>("Reader was removed", HttpStatus.OK);
    }
}
