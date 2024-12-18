package ru.practikum.numbers.model;

import lombok.Builder;
import lombok.Data;
import ru.practikum.numbers.validator.NonNull;

@Data
@Builder
public class Numbers {

    private Long id;

    @NonNull
    private Long num;
}