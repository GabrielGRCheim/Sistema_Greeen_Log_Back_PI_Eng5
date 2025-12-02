package com.senai.demo.dtos;

import com.senai.demo.models.entities.Bairro;
import com.senai.demo.models.enums.TipoResiduo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PontoColetaRequestDTO {

    @NotNull(message = "Bairro é obrigatorio")
    private Long bairroId;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    private String responsavel;
    private String telefoneResponsavel;
    private String emailResponsavel;
    private String endereco;

    private List<TipoResiduo> tiposResiduos;

    public PontoColetaRequestDTO() {
    }

    public Long getBairroId() {
        return bairroId;
    }

    public void setBairroId(Long bairroId) {
        this.bairroId = bairroId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<TipoResiduo> getTiposResiduos() {
        return tiposResiduos;
    }

    public void setTiposResiduos(List<TipoResiduo> tiposResiduos) {
        this.tiposResiduos = tiposResiduos;
    }

}
