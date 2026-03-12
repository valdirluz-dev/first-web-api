package com.my.web_api.controller;

import com.my.web_api.model.Usuario;
import com.my.web_api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "operações relacionadas a usuários" )
public class UsuarioController {

    @Autowired
    private UserRepository repository;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listar usuários", description = "retorna lista com todos usuários cadastrados")
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @PostMapping ()
    @Operation(summary = "Salvar usuários", description = "Salva usuarios no BD")
    @PreAuthorize("hasRole('ADMIN')")
    public void saveUser (@RequestBody Usuario user){
        repository.save(user);
    }

    @GetMapping (value = "/{nome}", produces = "application/json")
    @Operation (summary = "buscar usuário por nome")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario findByUsername(@PathVariable String nome) {
        return repository.findByUserName(nome);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Buscar usuário por id")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete (@PathVariable Integer id){
        repository.deleteById(id);
    }
}

