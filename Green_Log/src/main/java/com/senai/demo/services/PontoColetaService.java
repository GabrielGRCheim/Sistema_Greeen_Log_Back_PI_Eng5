package com.senai.demo.services;

import com.senai.demo.dtos.PontoColetaRequestDTO;
import com.senai.demo.dtos.PontoColetaResponseDTO;
import com.senai.demo.mappers.PontoColetaMapper;
import com.senai.demo.models.entities.PontoColeta;
import com.senai.demo.models.repositorys.PontoColetaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoColetaService {

    private final PontoColetaRepository repository;

    public PontoColetaService(PontoColetaRepository repository) {
        this.repository = repository;
    }

    public PontoColetaResponseDTO criarPontoColeta(PontoColetaRequestDTO dto) {
        PontoColeta entity = PontoColetaMapper.toEntity(dto);
        PontoColeta saved = repository.save(entity);
        return PontoColetaMapper.toDTO(saved);
    }

    public List<PontoColetaResponseDTO> listarTodos() {
        return PontoColetaMapper.toDTOList(repository.findAll());
    }

    public PontoColetaResponseDTO encontrarPorId(Long id) {
        PontoColeta entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ponto de coleta não encontrado com ID: " + id));
        return PontoColetaMapper.toDTO(entity);
    }

    public PontoColetaResponseDTO atualizar(Long id, PontoColetaRequestDTO dto) {
        PontoColeta entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ponto de coleta não encontrado com ID: " + id));

        PontoColetaMapper.updateEntity(entity, dto);

        PontoColeta updated = repository.save(entity);
        return PontoColetaMapper.toDTO(updated);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Ponto de coleta não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
