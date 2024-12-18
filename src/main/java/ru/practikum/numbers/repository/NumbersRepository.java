package ru.practikum.numbers.repository;

import ru.practikum.numbers.model.Numbers;

import java.util.List;

public interface NumbersRepository {
    List<Numbers> findAll();

    Numbers save(Numbers numbers);

    Numbers findById(Long id);

    void deleteById(Long id);
}