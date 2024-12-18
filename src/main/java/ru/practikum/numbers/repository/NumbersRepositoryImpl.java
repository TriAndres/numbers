package ru.practikum.numbers.repository;

import org.springframework.stereotype.Repository;
import ru.practikum.numbers.model.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NumbersRepositoryImpl implements NumbersRepository {
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    @Override
    public List<Numbers> findAll() {
        return new ArrayList<>(numbersMap.values());
    }

    @Override
    public Numbers save(Numbers numbers) {
        return numbersMap.put(numbers.getId(), numbers);
    }

    @Override
    public Numbers findById(Long id) {
        return numbersMap.get(id);
    }

    @Override
    public void deleteById(Long id) {
        numbersMap.remove(id);
    }
}