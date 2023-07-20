package com.example.learnspringbootlesson1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class CarDto {


    @NotEmpty(message = "Должно быть заполнено")
    private String model;

    @NotEmpty(message = "Должно быть заполнено")
    private String series;
}
