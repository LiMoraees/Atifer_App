package com.atifer.atifer.controller;

import java.util.List;
import java.util.Optional;

import com.atifer.atifer.model.Orcamento;
import com.atifer.atifer.repository.OrcamentoRepository;

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
public class OrcamentoController {
    @Autowired
    OrcamentoRepository orcamentoRepository;

    @GetMapping("/orcamento")
    public List<Orcamento> recuperaOrcamento(){
        return (List<Orcamento>) orcamentoRepository.findAll();
    }

    @GetMapping("/orcamento/{id}")
    public Optional<Orcamento> RecuperaOrcamentoPeloId(@PathVariable("id") Long id) {
        return orcamentoRepository.findById(id);
    }

    @PostMapping("/orcamento")
    public void adicionaOrcamento(@RequestBody Orcamento novoOrcamento){
        orcamentoRepository.save(novoOrcamento);
    }

    @DeleteMapping("/orcamento/{id}") 
    public void deletaOrcamento(@PathVariable("id") Long id){
        orcamentoRepository.deleteById(id);
    }
}
