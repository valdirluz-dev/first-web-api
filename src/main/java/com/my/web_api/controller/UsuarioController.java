package com.my.web_api.controller;

import com.my.web_api.model.Usuario;
import com.my.web_api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "operações relacionadas a usuários")
public class UsuarioController {

    @Autowired
    private UserRepository repository;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Listar usuários", description = "retorna lista com todos usuários cadastrados")
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "Salvar usuários", description = "Salva usuarios no BD")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario saveUser(@RequestBody Usuario user){
        return repository.save(user);
    }

    @GetMapping("/{login}")
    @Operation(summary = "buscar usuário por login", description = "example: nome@email.com")
    public Usuario findByLogin(@PathVariable String login) {
        return repository.findByLoginIgnoreCase(login.trim())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuário por id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
