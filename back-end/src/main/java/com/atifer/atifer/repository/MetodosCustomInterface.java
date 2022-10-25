package com.atifer.atifer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atifer.atifer.model.Vendedor;

public interface MetodosCustomInterface {
    // Queries customizadas

    // Query para buscar Usuário no Banco pelo nickname
    @Query(value = "SELECT * FROM vendedor WHERE nickname = :nickParametro", nativeQuery = true)
    Vendedor findVendedorByNickname(@Param("nickParametro") String nickname);

}