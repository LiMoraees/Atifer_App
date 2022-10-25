package com.atifer.atifer.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atifer.atifer.model.Vendedor;
import com.atifer.atifer.repository.VendedorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    VendedorRepository vendedorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra um vendedor no banco de dados
        Vendedor user = vendedorRepository.findByNickname(username).stream().findFirst().get();
        // Depois retorna um objeto UserDetailsImpl com base no vendedor encontrado
        return new UserDetailsImpl(user);        
    } 
}
