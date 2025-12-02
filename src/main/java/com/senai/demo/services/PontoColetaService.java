package com.senai.demo.services;

import com.senai.demo.dtos.PontoColetaRequestDTO;
import com.senai.demo.dtos.PontoColetaResponseDTO;
import com.senai.demo.mappers.PontoColetaMapper;
import com.senai.demo.models.entities.Bairro;
import com.senai.demo.models.entities.PontoColeta;
import com.senai.demo.models.enums.TipoResiduo;
import com.senai.demo.models.exceptions.BadRequestException;
import com.senai.demo.models.repositorys.BairroRepository;
import com.senai.demo.models.repositorys.PontoColetaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PontoColetaService {

    @Autowired
    private final PontoColetaRepository repository;

    @Autowired
    private final BairroRepository bairroRepository;

    @Autowired
    private final PontoColetaRepository pontoColetaRepository;

    public PontoColetaService(PontoColetaRepository repository, BairroRepository bairroRepository, PontoColetaRepository pontoColetaRepository) {
        this.repository = repository;
        this.bairroRepository = bairroRepository;
        this.pontoColetaRepository = pontoColetaRepository;
    }

    public PontoColetaResponseDTO criarPontoColeta(PontoColetaRequestDTO dto) {

        Bairro bairro = bairroRepository.findById(dto.getBairroId())
                .orElseThrow(() -> new EntityNotFoundException("Bairro não encontrado com ID: " + dto.getBairroId()));

        PontoColeta pontoColeta = pontoColetaRepository.findByBairroId(bairro.getId());

        if(pontoColeta != null){
            throw new BadRequestException("O bairro ja possui um Ponto de Coleta Cadastrado");
        }

        PontoColeta entity = PontoColetaMapper.toEntity(dto);
        entity.setBairro(bairro);

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

    public List<TipoResiduo> listarTiposResiduo() {
        return Arrays.stream(TipoResiduo.values()).toList();
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Ponto de coleta não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
