package com.atifer.atifer.controller;

import java.util.List;
import java.util.Optional;

import com.atifer.atifer.model.Venda;
import com.atifer.atifer.repository.VendaRepository;

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
public class VendaController {
    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("/venda")
    public List<Venda> recuperaVenda(){
        return (List<Venda>) vendaRepository.findAll();
    }

    @GetMapping("/venda/{id}")
    public Optional<Venda> RecuperaVendaPeloId(@PathVariable("id") Long id) {
        return vendaRepository.findById(id);
    }

    @PostMapping("/venda")
    public void adicionaVenda(@RequestBody Venda novaVenda){
        vendaRepository.save(novaVenda);
    }

    @DeleteMapping("/venda/{id}") 
    public void deletaVenda(@PathVariable("id") Long id){
        vendaRepository.deleteById(id);
    }
}
