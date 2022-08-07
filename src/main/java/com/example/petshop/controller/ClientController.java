package com.example.petshop.controller;

import com.example.petshop.model.Cliente;
import com.example.petshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/register")
    public ResponseEntity<Cliente> registerclient(@RequestBody Cliente obj){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand((clienteService.saveClient(obj)).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Cliente> deletClient(@RequestBody Long clientId){
        clienteService.deletClient(clientId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
