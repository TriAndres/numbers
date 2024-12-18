package ru.practikum.numbers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practikum.numbers.dto.NumbersDTO;
import ru.practikum.numbers.exception.DoesNotExistException;
import ru.practikum.numbers.model.Numbers;
import ru.practikum.numbers.repository.NumbersRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static ru.practikum.numbers.mapper.NumbersMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumbersServiceImpl implements NumbersService {
    private final NumbersRepository repository;

    @Override
    public Collection<NumbersDTO> findAll() {
        return new ArrayList<>(toListDTO(repository.findAll()));
    }

    @Override
    public NumbersDTO create(NumbersDTO numbers) {
        numbers.setId(getNextId());
        repository.save(toModel(numbers));
        log.info("Записано число с id={}.", numbers.getId());
        return numbers;
    }

    @Override
    public NumbersDTO update(NumbersDTO newNumbers) {
        if (repository.findById(newNumbers.getId()).orElseThrow().getId().equals(newNumbers.getId())) {
            Numbers old = repository.findById(newNumbers.getId()).orElseThrow();
            old.setNum(newNumbers.getNum());
            repository.save(old);
            log.info("Обновлено число с id={}.", old.getId());
            return toDTO(old);
        }
        log.info("Ошибка при обновлении");
        throw new DoesNotExistException("Число отсутствует.");
    }

    @Override
    public Optional<NumbersDTO> findById(Long id) {
        if (repository.findAll().contains(repository.findById(id).orElseThrow())) {
            log.info("Возврат по id={}", id);
            return Optional.ofNullable(toDTO(repository.findById(id).orElseThrow()));
        }
        log.info("Число c id={} отсутствует", id);
        throw new DoesNotExistException("Число отсутствует.");
    }

    @Override
    public void deleteId(Long id) {
        repository.deleteById(id);
        log.info("Удаление числа с id={}", id);

    }

    private long getNextId() {
        long currentMaxId = repository.findAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}