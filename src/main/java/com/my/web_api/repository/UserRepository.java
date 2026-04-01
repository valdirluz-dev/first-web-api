package com.my.web_api.repository;

import com.my.web_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

   Optional<Usuario> findByLoginIgnoreCase(String login);

}