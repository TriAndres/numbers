package ru.practikum.numbers.mapper;

import ru.practikum.numbers.dto.NumbersDTO;
import ru.practikum.numbers.model.Numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumbersMapper {
    public static NumbersDTO toDTO(Numbers numbers) {
        return NumbersDTO.builder()
                .id(numbers.getId())
                .num(numbers.getNum())
                .build();
    }

    public static List<NumbersDTO> toListDTO(List<Numbers> numbers) {
        return numbers.stream().map(NumbersMapper::toDTO).toList();
    }

    public static Numbers toModel(NumbersDTO numbersDTO) {
        return Numbers
                .builder()
                .id(numbersDTO.getId())
                .num(numbersDTO.getNum())
                .build();
    }

    public static List<Numbers> toListModel(List<NumbersDTO> numbersDTO) {
        List<Numbers> list = new ArrayList<>();
        for (NumbersDTO dto : numbersDTO) {
            list.add(toModel(dto));
        }
        return list;
    }
}