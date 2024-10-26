package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}