package com.senai.demo.dtos;

import com.senai.demo.models.entities.Caminhao;
import com.senai.demo.models.entities.Itinerario;
import com.senai.demo.models.entities.Rota;

import java.time.LocalDate;

public class ItinerarioResponseDTO {

    private Long id;
    private Caminhao caminhao;
    private Rota rota;
    private LocalDate dia;

    public ItinerarioResponseDTO(Long id, Caminhao caminhao, Rota rota, LocalDate dia) {
        this.id = id;
        this.caminhao = caminhao;
        this.rota = rota;
        this.dia = dia;
    }

    public Long getId() {
        return id;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
}
