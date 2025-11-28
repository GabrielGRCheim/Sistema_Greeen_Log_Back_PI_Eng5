package com.senai.demo.mappers;

import com.senai.demo.dtos.RotaRequestDTO;
import com.senai.demo.dtos.RotaResponseDTO;
import com.senai.demo.models.entities.Rota;

import java.util.List;
import java.util.stream.Collectors;

public class RotaMapper {

    // RequestDTO → Entity
    public static Rota toEntity(RotaRequestDTO dto) {
        if (dto == null) return null;

        Rota rota = new Rota();
        rota.setNome(dto.getNome());
        rota.setBairros(dto.getBairros());
        rota.setArestas(dto.getArestas());
        rota.setDistancia_total(dto.getDistancia_total());
        rota.setResiduos_atendidos(dto.getResiduos_atendidos());
        rota.setCaminhaoDesignado(dto.getCaminhaoDesignado());

        return rota;
    }

    // Entity → ResponseDTO
    public static RotaResponseDTO toDTO(Rota rota) {
        if (rota == null) return null;

        return new RotaResponseDTO(
                rota.getId(),
                rota.getCaminhaoDesignado(),
                rota.getNome(),
                rota.getBairros(),
                rota.getArestas(),
                rota.getDistancia_total(),
                rota.getResiduos_atendidos(),
                rota.getDataCriacao()
        );
    }

    // Atualizar entidade existente a partir do DTO
    public static void updateEntity(Rota rota, RotaRequestDTO dto) {
        if (rota == null || dto == null) return;

        rota.setNome(dto.getNome());
        rota.setBairros(dto.getBairros());
        rota.setArestas(dto.getArestas());
        rota.setDistancia_total(dto.getDistancia_total());
        rota.setResiduos_atendidos(dto.getResiduos_atendidos());
        rota.setCaminhaoDesignado(dto.getCaminhaoDesignado());
    }

    // Lista de entidades → Lista de DTO
    public static List<RotaResponseDTO> toDTOList(List<Rota> rotas) {
        if (rotas == null) return null;

        return rotas.stream()
                .map(RotaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
