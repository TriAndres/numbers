package ru.practikum.numbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practikum.numbers.model.Numbers;

import java.util.List;
@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long> {

//    List<Numbers> findAll();
//
//    Numbers save(Numbers numbers);
//
//    Numbers findById(Long id);
//
//    void deleteById(Long id);
}