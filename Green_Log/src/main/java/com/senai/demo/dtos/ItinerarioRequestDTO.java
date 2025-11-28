package com.senai.demo.dtos;

import com.senai.demo.models.entities.Caminhao;
import com.senai.demo.models.entities.Itinerario;
import com.senai.demo.models.entities.Rota;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ItinerarioRequestDTO {

    @NotBlank(message = "Caminhão é obrigatorio")
    private Caminhao caminhao;

    @NotBlank(message = "Rota deve ser selecionada")
    private Rota rota;

    @NotBlank(message = "Data é obrigatoria")
    private LocalDate dia;

    public ItinerarioRequestDTO() {}

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
