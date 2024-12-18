package ru.practikum.numbers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practikum.numbers.dto.NumbersDTO;
import ru.practikum.numbers.service.NumbersServiceImpl;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
@Slf4j
public class NumbersController {
    private final NumbersServiceImpl service;

    @GetMapping
    public ResponseEntity<Collection<NumbersDTO>> findAll() {
        log.info("findAll()");
        return  new ResponseEntity<>(service.findAll(), HttpStatus.valueOf(200));
    }

    @PostMapping()
    public ResponseEntity<NumbersDTO> create(@Valid @RequestBody NumbersDTO numbers) {
        log.info("create(Numbers numbers)");
        return new ResponseEntity<>(service.create(numbers), HttpStatus.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<NumbersDTO> update(@Valid @RequestBody NumbersDTO newNumbers) {
        log.info("update(Numbers newNumbers)");
        return new ResponseEntity<>(service.update(newNumbers), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NumbersDTO>> findById(@PathVariable long id) {
        log.info("findById(long id)");
        return new ResponseEntity<>(service.findById(id), HttpStatus.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable long id) {
        log.info("deleteId(long id)");
        service.deleteId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}