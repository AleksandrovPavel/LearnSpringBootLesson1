package com.example.learnspringbootlesson1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class UserDto {

    @NotEmpty(message = "Должно быть заполнено")
    private String firstName;

    @NotEmpty(message = "Должно быть заполнено")
    private String lastName;

    @Email
    private String email;
}
