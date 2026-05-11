package com.scupapp.serviceImpl;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import com.scupapp.entity.Kapcsolattarto;
import com.scupapp.mapper.KapcsolattartoMapper;
import com.scupapp.repository.KapcsolattartoRepository;
import com.scupapp.service.KapcsolattartoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KapcsolattartoServiceImpl implements KapcsolattartoService {

    private final KapcsolattartoMapper kapcsolattartoMapper;

    private final KapcsolattartoRepository kapcsolattartoRepository;

    @Override
    public String createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto) {
        Kapcsolattarto entity = kapcsolattartoMapper.toEntity(kapcsolattarto);
        try {
            kapcsolattartoRepository.save(entity);
            return "Kapcsolattarto created";
        }catch (Exception e){
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    @Transactional
    public KapcsolattartoOutputDTO updateKapcsolattarto(Long id, KapcsolattartoInputDTO kapcsolattartoInputDTO) {
        Kapcsolattarto entity = kapcsolattartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));

        if(kapcsolattartoInputDTO.getVezeteknev() != null) {
            entity.setVezeteknev(kapcsolattartoInputDTO.getVezeteknev());
        }

        if (kapcsolattartoInputDTO.getKeresztnev() != null) {
            entity.setKeresztnev(kapcsolattartoInputDTO.getKeresztnev());
        }

        if (kapcsolattartoInputDTO.getMobil() != null) {
            entity.setMobil(kapcsolattartoInputDTO.getMobil());
        }

        if (kapcsolattartoInputDTO.getEmail() != null) {
            entity.setEmail(kapcsolattartoInputDTO.getEmail());
        }

        KapcsolattartoOutputDTO response = kapcsolattartoMapper.toDto(entity);

        return response;
    }

    @Override
    public String deleteKapcsolattarto(Long id) {
        if (kapcsolattartoRepository.existsById(id)) {
            kapcsolattartoRepository.deleteById(id);
            return "Kapcsolattarto deleted";
        }else  {
            return "Kapcsolattarto not found";
        }
    }

    @Override
    public KapcsolattartoOutputDTO getKapcsolattarto(Long id) {
        return kapcsolattartoRepository.findById(id)
                .map(kapcsolattartoMapper::toDto) // Ha létezik, átalakítja DTO-vá
                .orElseThrow(() -> new EntityNotFoundException("Nincs ilyen!"));
    }
}
