package com.example.learnspringbootlesson1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;

    @NotEmpty(message = "Должно быть заполнено")
    private String firstName;

    @NotEmpty(message = "Должно быть заполнено")
    private String lastName;

    @Email
    private String email;
}
