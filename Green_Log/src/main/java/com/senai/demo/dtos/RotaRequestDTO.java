package com.senai.demo.dtos;

import com.senai.demo.models.entities.Caminhao;
import jakarta.validation.constraints.NotBlank;


public class RotaRequestDTO {

    @NotBlank(message = "Caminhao é obrigatorio")
    private Caminhao caminhaoDesignado;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    private String bairros;

    private String arestas;

    private Float distancia_total;

    @NotBlank(message = "Residuos é obrigatorio")
    private String residuos_atendidos;


    public RotaRequestDTO() {
    }


    public Caminhao getCaminhaoDesignado() {
        return caminhaoDesignado;
    }

    public void setCaminhaoDesignado(Caminhao caminhaoDesignado) {
        this.caminhaoDesignado = caminhaoDesignado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairros() {
        return bairros;
    }

    public void setBairros(String bairros) {
        this.bairros = bairros;
    }

    public String getArestas() {
        return arestas;
    }

    public void setArestas(String arestas) {
        this.arestas = arestas;
    }

    public Float getDistancia_total() {
        return distancia_total;
    }

    public void setDistancia_total(Float distancia_total) {
        this.distancia_total = distancia_total;
    }

    public String getResiduos_atendidos() {
        return residuos_atendidos;
    }

    public void setResiduos_atendidos(String residuos_atendidos) {
        this.residuos_atendidos = residuos_atendidos;
    }
}
