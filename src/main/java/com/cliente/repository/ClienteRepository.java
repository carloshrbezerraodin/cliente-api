package com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
