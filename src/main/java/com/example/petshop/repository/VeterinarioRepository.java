package com.example.petshop.repository;

import com.example.petshop.model.Cliente;
import com.example.petshop.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeterinarioRepository extends JpaRepository<Veterinario,Long> {
    Optional<Veterinario> findByCpf(String cpf);
}
