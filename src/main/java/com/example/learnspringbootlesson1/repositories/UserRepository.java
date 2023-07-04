package com.example.learnspringbootlesson1.repositories;

import com.example.learnspringbootlesson1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
