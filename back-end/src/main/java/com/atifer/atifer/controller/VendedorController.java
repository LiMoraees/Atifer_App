package com.atifer.atifer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.atifer.atifer.model.Vendedor;
import com.atifer.atifer.repository.VendedorRepository;

import com.atifer.atifer.security.jwt.JwtUtils;

@CrossOrigin
@RestController
public class VendedorController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtils jwtUtils;
    
    // Injeção Autowired
    @Autowired
    VendedorRepository vendedorRepository;


    @PostMapping("/user")
    public ResponseEntity<String> createvendedor(@RequestBody Vendedor vendedorNovo){
        // Se encontrar no banco, não poderá criar um novo usuário
        boolean exists = vendedorRepository.findByNome(vendedorNovo.getNome()).stream().count() > 0;
        // Mas não existir, cra o novo usuário no banco
        if(!exists){
            //criptografa a senha do usuário para por no banco de dados
            vendedorNovo.setSenha(
                passwordEncoder.encode(vendedorNovo.getSenha())
            );
            vendedorRepository.save(vendedorNovo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();    
    }

    @GetMapping("/user")
    public List<Vendedor> getAllvendedors(){
        return (List<Vendedor>)vendedorRepository.findAll();
    }
    
    @GetMapping("/user/me")
    public Vendedor getMyInformations(@RequestHeader("Authorization") String token){
        // String token = headers.firstValue("Authorization").get();
        System.out.println(token);
        token = token.substring(7, token.length());
        String nome = jwtUtils.getUserNameFromJwtToken(token);
        return vendedorRepository.findByNome(nome).get(0);
    }

    // Endpoints
    // @PostMapping("/cadastrar")
    // public void sign(@RequestBody Vendedor vendedor) {
    //     vendedorRepository.save(vendedor);
    // }

    // // Utilizando o Response Entity para tratar os status e facilitar a exibição no
    // // Front-End

    // @PostMapping("/logar")
    // public ResponseEntity<?> login(@RequestBody Map<String, Object> dados) {

    //     JSONObject candidato = new JSONObject(dados);

    //     // Dados do candidato
    //     String loginDoCandidato;
    //     String senhaDoCandidato;

    //     try {
    //         loginDoCandidato = candidato.getString("nickname");
    //         senhaDoCandidato = candidato.getString("senha");

    //         try {
    //             // Encontra no banco um vendedor com o nickname passado
    //             Vendedor vendedorNoBanco = vendedorRepository.findVendedorByNickname(loginDoCandidato);
    //             String senhaDoBanco = vendedorNoBanco.getSenha(); // <- Senha pura / sem hash

    //             // Autenticação
    //             boolean match = autenticar(senhaDoBanco, senhaDoCandidato);

    //             if (match) {
    //                 // Response - Login realizado com sucesso (200)
    //                 return new ResponseEntity<>(match, null, HttpStatus.OK);
    //             } else {
    //                 // Response - Credenciais invalidas (207)
    //                 return new ResponseEntity<>(match, null, HttpStatus.MULTI_STATUS); // LEMBRAR DE TRATAR NO FRONT-END
    //             }

    //         } catch (NoSuchElementException e) {

    //             // Response - Não encontrado (404)
    //             return new ResponseEntity<>(false, null, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
    //         }
    //     } catch (JSONException e) {
    //         // Response - Erro nas credenciais (400)
    //         return new ResponseEntity<>(false, null, HttpStatus.BAD_REQUEST); // LEMBRAR DE TRATAR NO FRONT-END
    //     }

    // }

    // @GetMapping("/vendedor/{id}")
    // public ResponseEntity<?> getDados(@PathVariable("id") Long id) {
    //     try {
    //         Vendedor u = vendedorRepository.findById(id).get();

    //         // Response - Tudo certo (200)
    //         return new ResponseEntity<>(u, null, HttpStatus.OK);
    //     } catch (Exception e) {
    //         // Response - Não encontrado (404)
    //         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // LEMBRAR DE TRATAR NO FRONT-END
    //     }
    // }

    // // Passar o método para classe vendedor, ou não, tanto faz
    // private boolean autenticar(String senhaDoBanco, String senhaDoCandidato) {
    //     if (senhaDoBanco.equals(senhaDoCandidato)) {
    //         return true;
    //     }

    //     return false;
    // }



    // @PostMapping("/user")
    // public ResponseEntity<String> createUser(@RequestBody Vendedor vendedorNovo){
    //     // Se encontrar no banco, não poderá criar um novo vendedor
    //     boolean exists = vendedorRepository.findByNickname(vendedorNovo.getNickname()).stream().count() > 0;
    //     // Mas não existir, cra o novo vendedor no banco
    //     if(!exists){
    //         //criptografa a senha do vendedor para por no banco de dados
    //         vendedorNovo.setSenha(
    //             passwordEncoder.encode(vendedorNovo.getSenha())
    //         );
    //         vendedorRepository.save(vendedorNovo);
    //         return ResponseEntity.status(HttpStatus.CREATED).build();
    //     }
    //     return ResponseEntity.status(HttpStatus.CONFLICT).build();    
    // }

    // @GetMapping("/user")
    // public List<Vendedor> getAllUsers(){
    //     return (List<Vendedor>)vendedorRepository.findAll();
    // }
    
    // @GetMapping("/user/me")
    // public Vendedor getMyInformations(@RequestHeader("Authorization") String token){
    //     // String token = headers.firstValue("Authorization").get();
    //     System.out.println(token);
    //     token = token.substring(7, token.length());
    //     String username = jwtUtils.getUserNameFromJwtToken(token);
    //     return vendedorRepository.findByNickname(username).get(0);
    // }

}
