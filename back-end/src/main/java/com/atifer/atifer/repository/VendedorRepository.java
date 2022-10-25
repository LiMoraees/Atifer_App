package com.atifer.atifer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atifer.atifer.model.Vendedor;


public interface VendedorRepository extends CrudRepository<Vendedor, Long>, MetodosCustomInterface {
    List<Vendedor> findByNickname(String nickname);
}
