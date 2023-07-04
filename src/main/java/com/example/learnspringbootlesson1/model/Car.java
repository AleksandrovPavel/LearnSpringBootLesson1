package com.example.learnspringbootlesson1.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "templates/user")
@EqualsAndHashCode(exclude = "templates/user")
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Должно быть заполнено")
    private String model;

    @NotEmpty(message = "Должно быть заполнено")
    private int series;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
