package com.example.petshop.service;

import com.example.petshop.model.Animal;
import com.example.petshop.model.Cliente;
import com.example.petshop.model.Veterinario;
import com.example.petshop.repository.AnimalRepository;
import com.example.petshop.repository.ClientRepository;
import com.example.petshop.repository.VeterinarioRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VeterinarioServiceTest {
    @InjectMocks
    private VeterinarioService vetservice;

    @Mock
    VeterinarioRepository veterinarioRepository;
    @Mock
    AnimalRepository animalRepository;

    @Mock
    ClientRepository clientRepository;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void saveVet() {
    }

    @Test
    void atenderUmAnimal() {
    }

    @Test
    void listarClientes() {
    }

    @Test
    void deletarcliente() {
    }

    @Test
    void findById() {
    }
    private void startClientAndVet(){
        Cliente cliente=new Cliente(1L,"Vanderson","30/10/1997","166.299.537-70", (List<Animal>) new Animal(1L,"boneca",23,83));
        Veterinario veterinario=new Veterinario(1L,"Lucas silveira","023.271.587-45",23,"23/10/2022",null);
    }
}