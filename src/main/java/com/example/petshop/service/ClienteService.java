package com.example.petshop.service;

import com.example.petshop.exception.ExceptionClient;
import com.example.petshop.exception.InvalidValueException;
import com.example.petshop.model.Cliente;
import com.example.petshop.repository.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClientRepository clientRepository;

    public Cliente saveClient(Cliente cliente) {
           findByCpf(cliente);

        return clientRepository.save(cliente);
    }
    private void findByCpf(Cliente cliente){
        Optional<Cliente> cliente1=clientRepository.findByCpf(cliente.getCpf());
        if (cliente1.isPresent() && !cliente1.get().getId().equals(cliente.getId())){
            throw new ExceptionClient("cpf ja cadastrado no sistema");
        }
    }
    public void deletClient(Long id){
        findById(id);
        clientRepository.deleteById(id);
    }
    public Cliente findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new InvalidValueException("id não encontrado"));
    }


}

