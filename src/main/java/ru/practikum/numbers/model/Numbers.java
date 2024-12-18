package ru.practikum.numbers.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import ru.practikum.numbers.validator.NonNull;

@Data
@Builder
@Entity
@Table(name = "number")
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "num")
    private Long num;
}