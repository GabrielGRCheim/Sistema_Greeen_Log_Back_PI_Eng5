package com.senai.demo.dtos;

public class LoginResponseDTO {
    private String mensagem;
    private boolean autenticado;

    public LoginResponseDTO(String mensagem, boolean autenticado) {
        this.mensagem = mensagem;
        this.autenticado = autenticado;
    }
}
