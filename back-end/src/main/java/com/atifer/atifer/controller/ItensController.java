package com.atifer.atifer.controller;

import java.util.List;
import java.util.Optional;

import com.atifer.atifer.model.Itens;
import com.atifer.atifer.repository.ItensRepository;

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
public class ItensController {
    @Autowired
    ItensRepository itensRepository;

    @GetMapping("/itens")
    public List<Itens> recuperaItens(){
        return (List<Itens>) itensRepository.findAll();
    }

    @GetMapping("/itens/{id}")
    public Optional<Itens> RecuperaItensPeloId(@PathVariable("id") Long id) {
        return itensRepository.findById(id);
    }

    @PostMapping("/itens")
    public void adicionaItens(@RequestBody Itens novoItem){
        itensRepository.save(novoItem);
    }

    @DeleteMapping("/itens/{id}") 
    public void deletaItens(@PathVariable("id") Long id){
        itensRepository.deleteById(id);
    }
}
