package com.scupapp.serviceImpl;

import com.scupapp.dto.input.TemaInputDTO;
import com.scupapp.dto.output.TemaOutputDTO;
import com.scupapp.entity.Tema;
import com.scupapp.mapper.TemaMapper;
import com.scupapp.repository.TemaRepository;
import com.scupapp.service.TemaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TemaServiceImpl implements TemaService {

    private final TemaMapper temaMapper;

    private final TemaRepository temaRepository;

    @Override
    public ResponseEntity<String> createTema(TemaInputDTO temaInputDTO){
        Tema entity = temaMapper.toEntity(temaInputDTO);
        try{
            temaRepository.save(entity);
            return ResponseEntity.ok().body("Tema saved");
        } catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<TemaOutputDTO> updateTema(Long id, TemaInputDTO temaInputDTO) {
        Tema entity = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs"));
        if (temaInputDTO.getNev() != null) {
            entity.setNev(temaInputDTO.getNev());
        }
        if (temaInputDTO.getLeiras() != null) {
            entity.setLeiras(temaInputDTO.getLeiras());
        }

        TemaOutputDTO response = temaMapper.toDto(entity);

        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<String> deleteTema(Long id) {
        if (temaRepository.existsById(id)) {
            temaRepository.deleteById(id);
            return ResponseEntity.ok().body("Tema deleted");
        }else  {
            return ResponseEntity.badRequest().body("Tema not found");
        }
    }

    @Override
    public ResponseEntity<TemaOutputDTO> getTema(Long id) {
        return temaRepository.findById(id)
                .map(temaMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new EntityNotFoundException("Nincs ilyen!"));
    }
}
