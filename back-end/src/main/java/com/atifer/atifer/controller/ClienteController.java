package com.atifer.atifer.controller;

import java.util.List;
import java.util.Optional;

import com.atifer.atifer.model.Cliente;
import com.atifer.atifer.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public List<Cliente> recuperacliente(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> RecuperaclientePeloId(@PathVariable("id") Long id) {
        return clienteRepository.findById(id);
    }

    @PostMapping("/cliente")
    public void adicionacliente(@RequestBody Cliente novoCliente){
        clienteRepository.save(novoCliente);
    }

    @DeleteMapping("/cliente/{id}") 
    public void deletacliente(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
    }
}
