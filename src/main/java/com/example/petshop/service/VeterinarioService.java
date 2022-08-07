package com.example.petshop.service;

import com.example.petshop.exception.ExceptionClient;
import com.example.petshop.exception.InvalidValueException;
import com.example.petshop.model.Animal;
import com.example.petshop.model.Cliente;
import com.example.petshop.model.Veterinario;
import com.example.petshop.repository.AnimalRepository;
import com.example.petshop.repository.ClientRepository;
import com.example.petshop.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeterinarioService {
    @Autowired
    VeterinarioRepository veterinarioRepository;
    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    ClientRepository clientRepository;

    public Veterinario saveVet(Veterinario veterinario) {
        findByCpf(veterinario);
       return veterinarioRepository.save(veterinario);
    }

    private void findByCpf(Veterinario veterinario) {
        Optional<Veterinario> veterinario1 = veterinarioRepository.findByCpf(veterinario.getCpf());
        if (veterinario1.isPresent() && !veterinario1.get().getId().equals(veterinario.getId())) {
            throw new ExceptionClient("ja existe no banco alguem com esse cpf");
        }
    }

    public void atenderUmAnimal(Long idVeterinario, Long idAnimal) {
       Veterinario veterinario=veterinarioRepository.findById(idVeterinario).orElseThrow(()->new RuntimeException());
       Animal animal=animalRepository.findById(idAnimal).orElseThrow(()->new RuntimeException());
       veterinario.getAnimal().add(animal);
       veterinarioRepository.save(veterinario);
    }
    public List<Cliente> listarClientes(){
        return clientRepository.findAll();
    }
    public void deletarcliente(Long id){
        findById(id);
        clientRepository.deleteById(id);

    }
    public Cliente findById(Long id){
        return clientRepository.findById(id).orElseThrow(()->new InvalidValueException("id não encontrado"));
    }


}
