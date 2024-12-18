package ru.practikum.numbers.service;

import ru.practikum.numbers.dto.NumbersDTO;

import java.util.Collection;
import java.util.Optional;

public interface NumbersService {
    Collection<NumbersDTO> findAll();

    NumbersDTO create(NumbersDTO numbers);

    NumbersDTO update(NumbersDTO newNumbers);

    Optional<NumbersDTO> findById(long id);

    void deleteId(long id);
}