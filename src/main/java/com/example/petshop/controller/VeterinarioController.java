package com.example.petshop.controller;

import com.example.petshop.dto.DtoCliente;
import com.example.petshop.model.Cliente;
import com.example.petshop.model.Veterinario;
import com.example.petshop.service.ClienteService;
import com.example.petshop.service.VeterinarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veterinario")

public class VeterinarioController {

    @Autowired
    VeterinarioService veterinarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<Cliente> registerclient(@RequestBody Veterinario obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand((veterinarioService.saveVet(obj)).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/toAnimal/{idVeterinario}/{idAnimal}")
    public ResponseEntity<Void> updateVeterinario(@PathVariable Long idVeterinario, @PathVariable Long idAnimal) {
        veterinarioService.atenderUmAnimal(idVeterinario,idAnimal);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/listar/clientes/all")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok().body(veterinarioService.listarClientes());

    }
    @GetMapping(value = "/procurar/client/{idCliente}")
    public ResponseEntity<DtoCliente> procurarPorCliente(@PathVariable Long idCliente){

        return ResponseEntity.ok().body(mapper.map(veterinarioService.findById(idCliente), DtoCliente.class));

    }

    @DeleteMapping(value = "/delete/cliente/{deletecliente}")
    public ResponseEntity<Cliente> deletarClient(@PathVariable Long deletecliente){
        veterinarioService.deletarcliente(deletecliente);
      return  ResponseEntity.noContent().build();

    }
}