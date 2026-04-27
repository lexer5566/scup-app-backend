package com.scupapp.serviceImpl;

import com.scupapp.dto.input.KapcsolattartoInputDTO;
import com.scupapp.dto.output.KapcsolattartoOutputDTO;
import com.scupapp.entity.Kapcsolattarto;
import com.scupapp.mapper.KapcsolattartoMapper;
import com.scupapp.repository.KapcsolattartoRepository;
import com.scupapp.service.KapcsolattartoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KapcsolattartoServiceImpl implements KapcsolattartoService {

    private final KapcsolattartoMapper kapcsolattartoMapper;

    private final KapcsolattartoRepository kapcsolattartoRepository;

    @Override
    public ResponseEntity<String> createKapcsolattarto(KapcsolattartoInputDTO kapcsolattarto) {
        Kapcsolattarto entity = kapcsolattartoMapper.toEntity(kapcsolattarto);
        try {
            kapcsolattartoRepository.save(entity);
            return ResponseEntity.ok().body("Kapcsolattarto created");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<KapcsolattartoOutputDTO> updateKapcsolattarto(Long id, KapcsolattartoInputDTO kapcsolattartoInputDTO) {
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

        return ResponseEntity.ok().body(response);
    }


}
