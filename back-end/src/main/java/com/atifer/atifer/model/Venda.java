package com.atifer.atifer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data, formaPag;
    private double valor;

    @OneToOne(mappedBy = "venda") 
    @JsonBackReference
    private Orcamento orcamento;

    public Venda(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
