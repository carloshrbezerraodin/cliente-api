package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
