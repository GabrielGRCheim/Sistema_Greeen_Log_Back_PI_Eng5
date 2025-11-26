package com.senai.demo.services;

import com.senai.demo.dtos.ItinerarioRequestDTO;
import com.senai.demo.dtos.ItinerarioResponseDTO;
import com.senai.demo.mappers.ItinerarioMapper;
import com.senai.demo.models.entities.Itinerario;
import com.senai.demo.models.repositorys.ItinerarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {

    private final ItinerarioRepository itinerarioRepository;

    public ItinerarioService(ItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    public ItinerarioResponseDTO criarItinerario(ItinerarioRequestDTO dto) {
        Itinerario entity = ItinerarioMapper.toEntity(dto);
        Itinerario saved = itinerarioRepository.save(entity);
        return ItinerarioMapper.toDTO(saved);
    }

    public List<ItinerarioResponseDTO> listarTodos() {
        List<Itinerario> lista = itinerarioRepository.findAll();
        return ItinerarioMapper.toDTOList(lista);
    }

    public ItinerarioResponseDTO encontrarPorId(Long id) {
        Itinerario entity = itinerarioRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Itinerário não encontrado com ID: " + id));

        return ItinerarioMapper.toDTO(entity);
    }

    public ItinerarioResponseDTO atualizar(Long id, ItinerarioRequestDTO dto) {
        Itinerario entity = itinerarioRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Itinerário não encontrado com ID: " + id));

        // Atualiza usando o mapper
        ItinerarioMapper.updateEntity(entity, dto);

        Itinerario updated = itinerarioRepository.save(entity);

        return ItinerarioMapper.toDTO(updated);
    }

    public void deletar(Long id) {
        if (!itinerarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Itinerário não encontrado com ID: " + id);
        }

        itinerarioRepository.deleteById(id);
    }
}
