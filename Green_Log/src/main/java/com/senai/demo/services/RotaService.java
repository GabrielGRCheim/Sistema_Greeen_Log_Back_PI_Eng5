package com.senai.demo.services;

import com.senai.demo.dtos.RotaRequestDTO;
import com.senai.demo.dtos.RotaResponseDTO;
import com.senai.demo.mappers.RotaMapper;
import com.senai.demo.models.entities.Rota;
import com.senai.demo.models.repositorys.RotaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    private final RotaRepository repository;

    public RotaService(RotaRepository repository) {
        this.repository = repository;
    }

    public RotaResponseDTO criarRota(RotaRequestDTO dto) {
        Rota entity = RotaMapper.toEntity(dto);
        Rota saved = repository.save(entity);
        return RotaMapper.toDTO(saved);
    }

    public List<RotaResponseDTO> listarTodos() {
        return RotaMapper.toDTOList(repository.findAll());
    }

    public RotaResponseDTO encontrarPorId(Long id) {
        Rota entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rota não encontrada com ID: " + id));
        return RotaMapper.toDTO(entity);
    }

    public RotaResponseDTO atualizar(Long id, RotaRequestDTO dto) {
        Rota entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rota não encontrada com ID: " + id));

        RotaMapper.updateEntity(entity, dto);

        Rota updated = repository.save(entity);
        return RotaMapper.toDTO(updated);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Rota não encontrada com ID: " + id);
        }
        repository.deleteById(id);
    }
}
