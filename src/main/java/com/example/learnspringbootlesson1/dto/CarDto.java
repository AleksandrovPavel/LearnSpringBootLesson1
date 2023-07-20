package com.example.learnspringbootlesson1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarDto {


    @NotEmpty(message = "Должно быть заполнено")
    private String model;

    @NotEmpty(message = "Должно быть заполнено")
    private String series;
}
