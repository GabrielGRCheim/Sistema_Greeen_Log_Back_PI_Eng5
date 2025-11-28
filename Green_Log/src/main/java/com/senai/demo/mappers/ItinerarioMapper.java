package com.senai.demo.mappers;

import com.senai.demo.dtos.ItinerarioRequestDTO;
import com.senai.demo.dtos.ItinerarioResponseDTO;
import com.senai.demo.models.entities.Itinerario;

import java.util.List;
import java.util.stream.Collectors;

public class ItinerarioMapper {

    // REQUEST DTO → ENTIDADE
    public static Itinerario toEntity(ItinerarioRequestDTO dto) {
        if (dto == null) return null;

        Itinerario itinerario = new Itinerario();
        itinerario.setCaminhao(dto.getCaminhao());
        itinerario.setRota(dto.getRota());
        itinerario.setDia(dto.getDia());

        return itinerario;
    }

    // ENTIDADE → RESPONSE DTO
    public static ItinerarioResponseDTO toDTO(Itinerario itinerario) {
        if (itinerario == null) return null;

        return new ItinerarioResponseDTO(
                itinerario.getId(),
                itinerario.getCaminhao(),
                itinerario.getRota(),
                itinerario.getDia()
        );
    }

    // ATUALIZA ENTIDADE EXISTENTE A PARTIR DO DTO
    public static void updateEntity(Itinerario entity, ItinerarioRequestDTO dto) {
        if (entity == null || dto == null) return;

        entity.setCaminhao(dto.getCaminhao());
        entity.setRota(dto.getRota());
        entity.setDia(dto.getDia());
    }

    // LISTA DE ENTIDADES → LISTA DE DTO
    public static List<ItinerarioResponseDTO> toDTOList(List<Itinerario> lista) {
        if (lista == null) return null;

        return lista.stream()
                .map(ItinerarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
