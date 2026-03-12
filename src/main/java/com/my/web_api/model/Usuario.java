package com.my.web_api.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Usuario {

    @Schema(description = "id do usuário", example = "1")
    private Integer id;

    @Schema(description = "login do usuário", example = "nome@email.com")
    private String login;

    @Schema(description = "senha do usuário", example = "admin123")
    private String senha;

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
}
