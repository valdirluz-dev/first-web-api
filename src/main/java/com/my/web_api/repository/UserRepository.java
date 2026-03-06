package com.my.web_api.repository;

import org.springframework.stereotype.Repository;
import com.my.web_api.model.Usuario;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    public void save(Usuario usuario) {
        if (usuario.getId() == null) {
            System.out.println("SAVE - recebendo o usuario na camada de repositório ");
        } else {
            System.out.println("UPDATE - recebendo o usuario na camada de repositório");
        }
    }

    public void deleteById(Integer id) {
        System.out.printf("DELETE/id - recebendo o código: %d para exluir um usuario", id);
    }

    public List<Usuario> findAll() {
        System.out.println("List - listando os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario ("grandpa", "password"));
        usuarios.add(new Usuario ("grandmother", "password"));
        return usuarios;
    }

    public Usuario findByUserName(String username){
        System.out.printf("FIND USERNAME - Recebendo username %s para localizá-lo\n", username);
        return new Usuario("father", "password");
    }
}
