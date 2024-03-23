package com.example.kataboot.repository;

import com.example.kataboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
