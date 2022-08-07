package com.example.petshop.repository;

import com.example.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente>findByCpf(String cpf);
}
