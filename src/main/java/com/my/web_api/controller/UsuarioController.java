package com.my.web_api.controller;

import com.my.web_api.model.Usuario;
import com.my.web_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UserRepository repository;

    @GetMapping()
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @PostMapping ()
    public void saveUser (@RequestBody Usuario user){
        repository.save(user);
    }

    @GetMapping ("/{nome}")
    public Usuario findByUsername(@PathVariable String nome) {
        return repository.findByUserName(nome);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        repository.deleteById(id);
    }
}

