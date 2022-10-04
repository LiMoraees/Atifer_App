package com.atifer.atifer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome, dataNas, telefone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cliente")
    @JsonManagedReference
    private List<Orcamento> orcamentos;

    public Cliente() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }
    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNas() {
        return dataNas;
    }
    public void setDataNas(String dataNas) {
        this.dataNas = dataNas;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}