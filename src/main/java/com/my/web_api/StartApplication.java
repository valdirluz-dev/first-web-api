package com.my.web_api;

import com.my.web_api.model.Usuario;
import com.my.web_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public void run (String...args) throws Exception {
        Usuario user = repository.findByLogin("admin");
        if (user == null) {
            user = new Usuario();
            user.setNome("ADMIN");
            user.setLogin("admin");
            user.setSenha(encoder.encode("Master 123"));
            user.getRoles().add("ADMIN");
            repository.save(user);
        }
    }
}
