package com.my.web_api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_user")
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @Schema(description = "id do usuário", example = "1")
    private Integer id;

    @Schema(description = "nome do usuário", example = "joao")
    @Column(length = 50, nullable = false)
    private String nome;

    @Schema(description = "login do usuário", example = "nome@email.com")
    @Column(length = 50, nullable = false)
    private String login;

    @Schema(description = "senha do usuário", example = "admin123")
    @Column(length = 100, nullable = false) //por causa do encoder
    private String senha;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role_id")
    private List<String> roles = new ArrayList<>();

    public Usuario(){}

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
